package hello.hellobasic;

import hello.hellobasic.exception.CustomNotFoundException;
import hello.hellobasic.exception.CustomValidationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ExceptionHandlerController {

    @GetMapping("/{id}")
    public String handleException(@PathVariable("id") String id) {
        if("notfound".equals(id)) {
            throw new CustomNotFoundException("CustomNotFoundException");

        }else if("invalid".equals(id)) {
            throw new CustomValidationException("CustomValidationException");

        }
        throw new RuntimeException("RuntimeException");
    }
/*
    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleCustomNotFoundException(CustomNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponseException(HttpStatus.FORBIDDEN);
        return new ResponseEntity<>(errorResponse.getBody(), HttpStatus.FORBIDDEN);
    }*/
}
