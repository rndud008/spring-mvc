package hello.hellobasic;

import hello.hellobasic.custom.CustomAnnotation;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
//@Order(2)
public class GlobalControllerAdvice {

    @ModelAttribute("user") // 모든 뷰에서 전역적으로 모델 데이터를 참조할 수 있다
    public User modelAttribute() {
        return new User("springmvc", "a@a.com");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @CustomAnnotation
    public void customAnnotation1(Model model) {
        model.addAttribute("custom1", "커스텀 기능이 구현했습니다-1.");
    }

    @CustomAnnotation
    public void customAnnotation2(Model model) {
        model.addAttribute("custom2", "커스텀 기능이 구현했습니다-2.");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleIllegalArgumentException(IllegalArgumentException ex) {
        ModelAndView mav = new ModelAndView("error");
        mav.addObject("message", ex.getMessage());
        return mav;
    }
}