package hello.hellobasic.exception;

public class CustomValidationException extends RuntimeException {
    public CustomValidationException(String customValidationException) {
        super(customValidationException);
    }
}
