package org.clubhive.DTO;

public class ErrorDTO {
    private String message;
    private String error;

    public ErrorDTO(String message, String error) {
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }
}
