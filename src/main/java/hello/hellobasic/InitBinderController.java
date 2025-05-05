package hello.hellobasic;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class InitBinderController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @InitBinder
    public void initBinder2(WebDataBinder binder) {
//        binder.setAllowedFields("username", "email");
//        binder.setDisallowedFields("email");
        binder.setRequiredFields("username");
    }


    @PostMapping("/submitDate")
    @ResponseBody
    public String submitDate(DateModel dateModel, Model model) {
        model.addAttribute("date", dateModel.getDate());
        return dateModel.getDate().toString();
    }

    @PostMapping("/users")
    @ResponseBody
    public User users(@ModelAttribute User user, Model model) {
        return user;
    }
}
