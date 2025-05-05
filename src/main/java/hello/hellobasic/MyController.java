package hello.hellobasic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @GetMapping("/form") // 폼 페이지를 반환
    public String showForm(Model model) {
        model.addAttribute("myModel", new MyModel());
        return "formatForm";
    }
    @PostMapping("/submit") // 폼 데이터를 처리하고 결과를 반환
    public String handleSubmit(@ModelAttribute  MyModel myModel, Model model) {
        model.addAttribute("myModel", myModel);
        return "formatResult";
    }
}