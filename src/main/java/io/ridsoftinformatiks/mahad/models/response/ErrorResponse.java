package io.ridsoftinformatiks.mahad.models.response;

public class ErrorResponse {
    private String  code;
    private String errorField;
    private String errorMessage;

    public ErrorResponse() {
    }

    private ErrorResponse(String code, String errorField, String errorMessage) {
        this.code = code;
        this.errorField = errorField;
        this.errorMessage = errorMessage;
    }

    public static ErrorResponse of(String code, String errorField, String errorMessage) {
        return new ErrorResponse(code, errorField, errorMessage);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorField() {
        return errorField;
    }

    public void setErrorField(String errorField) {
        this.errorField = errorField;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
