package hello.hellobasic.exception;
public class ParentException extends RuntimeException {
    public ParentException(String message) {
        super(message);
    }
}