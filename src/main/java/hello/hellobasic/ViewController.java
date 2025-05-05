package hello.hellobasic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class ViewController {

    @GetMapping("/home")
    public String viewName() {
        return "home"; // ViewResolver에 의해 home.jsp 또는 home.html 렌더링
    }

    @GetMapping("/modelAndView")
    public ModelAndView modelAndView(Model model) {
        ModelAndView mav = new ModelAndView("home"); // 렌더링할 뷰 이름 설정
        model.addAttribute("message", "Hello World");  // 데이터 저장
        return mav;
    }

    @GetMapping(value = "/customView")
    public ModelAndView getCustomView() {
        ModelAndView mav = new ModelAndView("customView");
        mav.addObject("message", "Hello, Custom View!");
        mav.addObject("status", "success");
        return mav;
    }

    @GetMapping("/model")
    public Model model(Model model) {
        model.addAttribute("message", "Hello Model");
        return model;  // Model을 반환하여 데이터만 제공 (뷰 이름은 요청 경로를 기준으로 자동 결정)
    }
}
