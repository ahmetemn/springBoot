package com.newjavaapiproject.newjavaapiproject.response;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

/// restApi için tektipte bir response yapısı geliştiricez
public class InternalApiResponse<T> {

    /// generic type = T bu alanı isteidğimiz herhangi bir tipte data veririrz ?
    private FriendlyMessage friendlyMessage;
    private T payload; // T vererek payload = response vericez herhangi bir tipte data verebiliriz .
    private boolean hasError; // error olşuşup oluşmadığı.
    private List<String> errorMessage;
    private HttpStatus httpStatus; // status loglar;

}
