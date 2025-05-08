package hello.hellobasic.exception;

public class CustomNotFoundException extends RuntimeException{
    public CustomNotFoundException(String customNotFoundException) {
        super(customNotFoundException);
    }
}
