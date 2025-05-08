package hello.hellobasic;

import hello.hellobasic.exception.ChildException1;
import hello.hellobasic.exception.ChildException2;
import hello.hellobasic.exception.ParentException;
import hello.hellobasic.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExceptionHandlerController {

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") String id) {
        throw new UserNotFoundException("User ID: " + id);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users")
    public String getUsers(@RequestParam("name") String name) {
        if("child1".equals(name)) {
            throw new ChildException1("ChildException1");

        }else if("child2".equals(name)) {
            throw new ChildException2("ChildException2");

        }else{
            throw new ParentException("ParentException");
        }
    }

    @ExceptionHandler(ChildException1.class)
    public String handleChildException1(ChildException1 ex) {
        return "error/401";
    }
/*
    @ExceptionHandler(ChildException2.class)
    @ResponseBody
    public String handleChildException2(ChildException2 ex) {
        return "ChildException2 : " + ex.getMessage();
    }

    @ExceptionHandler(ParentException.class)
    @ResponseBody
    public String handleParentException(ParentException ex) {
        return "ParentException : " + ex.getMessage();
    }

    @ExceptionHandler({ChildException1.class, ChildException2.class, ParentException.class})
    @ResponseBody
    public String handleExceptions(ParentException ex) {
        return "error/401";
    }

    @GetMapping("/default")
    public String getDefault() {
        throw new IllegalStateException("IllegalStateException");
    }

    @ExceptionHandler
    @ResponseBody
    public String handleDefault(IllegalStateException ex) {
        return "Exception : " + ex.getMessage();
    }*/

}