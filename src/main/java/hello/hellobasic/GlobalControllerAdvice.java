package hello.hellobasic;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
@Order(2)
public class GlobalControllerAdvice {

    @ModelAttribute("user")
    public User getUser() {
        return new User("springmvc", "a@gmail.com");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgumentException(IllegalArgumentException ex) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", ex.getMessage() + ": ControllerAdvice");
        return mav;
    }
}
