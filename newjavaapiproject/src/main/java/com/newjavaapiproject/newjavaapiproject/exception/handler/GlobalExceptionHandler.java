package com.newjavaapiproject.newjavaapiproject.exception.handler;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.newjavaapiproject.newjavaapiproject.exception.enums.FriendlyMessageCodes;
import com.newjavaapiproject.newjavaapiproject.exception.enums.utils.FriendlyMessageUtils;
import com.newjavaapiproject.newjavaapiproject.exception.exceptions.ProductNotCreatedException;
import com.newjavaapiproject.newjavaapiproject.response.FriendlyMessage;
import com.newjavaapiproject.newjavaapiproject.response.InternalApiResponse;

@RestControllerAdvice // anotasyonu, Spring Boot uygulamalarında global düzeyde bir hata işleme ve
                      // yönetme mekanizması sağlar.
// Bu anotasyon, bir sınıfa uygulandığında, bu sınıfın global bir hata işleme
// bileşeni olduğunu belirtir.
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // requestin uygun olarak gönderilmemesi . !!!
    @ExceptionHandler(ProductNotCreatedException.class) //
    public InternalApiResponse<String> handleProductNotCreatedException(ProductNotCreatedException exception) {

        return InternalApiResponse.<String>builder()
                .friendlyMessage(FriendlyMessage.builder()
                        .title(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),
                                FriendlyMessageCodes.ERROR))
                        .description(FriendlyMessageUtils.getFriendlyMessage(exception.getLanguage(),
                                exception.getFriendlyMessageCode()))
                        .build())

                .httpStatus(HttpStatus.BAD_REQUEST)
                .hasError(true)
                .errorMessage(Collections.singletonList(exception.getMessage())) // herhangi bir ekleme çıkarma
                                                                                 // yapılamaz
                .build();
    }
}
