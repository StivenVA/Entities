package org.clubhive.DTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponse<T> extends ResponseEntity<T> {
    private String message;

    public CustomResponse(T body, HttpStatus status, String message) {
        super(body, status);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
