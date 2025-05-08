package hello.hellobasic;

import hello.hellobasic.exception.CustomNotFoundException;
import hello.hellobasic.exception.CustomValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//@ControllerAdvice(assignableTypes = UserController.class)
//@ControllerAdvice(basePackages = "hello.hellobasic.user")
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleCustomNotFoundException(CustomNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponseException(HttpStatus.NOT_FOUND,ex);
        return new ResponseEntity<>(errorResponse.getBody(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<ProblemDetail> handleCustomNotFoundException(CustomValidationException ex) {
        ErrorResponse errorResponse = new ErrorResponseException(HttpStatus.BAD_REQUEST,ex);
        return new ResponseEntity<>(errorResponse.getBody(), HttpStatus.BAD_REQUEST);
    }
}
