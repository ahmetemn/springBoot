package com.newjavaapiproject.newjavaapiproject.exception.exceptions;

import com.newjavaapiproject.newjavaapiproject.enums.Language;
import com.newjavaapiproject.newjavaapiproject.exception.enums.IFriendlyMessageCode;
import com.newjavaapiproject.newjavaapiproject.exception.enums.utils.FriendlyMessageUtils;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter

// Servisimizde product a gönderdiğimiz request in eklenememe durumu
// antiexception olduğu için class ı runtımeexception ile extends ettik .
public class ProductNotCreatedException extends RuntimeException {

    private final Language language;
    private final IFriendlyMessageCode friendlyMessageCode;

    public ProductNotCreatedException(Language language, IFriendlyMessageCode friendlyMessageCode, String message) {
        super(FriendlyMessageUtils.getFriendlyMessage(language, friendlyMessageCode)); // ilk satıra yaz .super ile
                                                                                       // runtimexception constructor
                                                                                       // ına ulaşırız . Run time
                                                                                       // exception a mesajı gönderdik.
        this.language = language;
        this.friendlyMessageCode = friendlyMessageCode;
        log.error("[ProductNotCreatedException] -> message: {} developer message:{}",
                FriendlyMessageUtils.getFriendlyMessage(language, friendlyMessageCode), message);

    }
}
