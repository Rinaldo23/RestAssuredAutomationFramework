package org.api.models.response;

public class CreateUserResponse {

    String code;
    String type;
    String message;

    public CreateUserResponse() {
    }

    public CreateUserResponse(String code, String message, String type) {
        this.code = code;
        this.message = message;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public CreateUserResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CreateUserResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getType() {
        return type;
    }

    public CreateUserResponse setType(String type) {
        this.type = type;
        return this;
    }
}
