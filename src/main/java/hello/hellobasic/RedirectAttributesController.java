package hello.hellobasic;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.FlashMapManager;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
public class RedirectAttributesController {

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/users")
    public String saveUser(User user, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("username", user.getUsername());
        redirectAttributes.addAttribute("email", user.getEmail());
        return "redirect:/users/success";
    }

    @GetMapping("/users/success")
    public String successPage(Model model,@ModelAttribute User user) {
        model.addAttribute("user", user);
        return "redirectSuccess";
    }

    @GetMapping("/setFlash")
    public String setFlash(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("flashMessage", "이것은 1회성 플래시 메시지입니다.");
        return "redirect:/getFlash";
    }

    @GetMapping("/getFlash")
    public String getFlash(Model model) {
        String message = (String)model.asMap().get("flashMessage");
        model.addAttribute("message", message);
        return "redirectSuccess";
//        return "redirect:/getFlashAgain";
    }

    @GetMapping("/getFlashAgain")
    public String getFlashAgain(Model model) {
        String message = (String)model.asMap().get("flashMessage");
        model.addAttribute("message", message);
        return "redirectSuccess";
    }

    @GetMapping("/setFlashAttribute")
    public RedirectView setFlashAttribute(HttpServletRequest request, HttpServletResponse response) {
//        FlashMap flashMap = new FlashMap(); // 출력 FlashMap 을 생성하고 플래시 속성 추가
        FlashMapManager flashMapManager = RequestContextUtils.getFlashMapManager(request); // FlashMapManager 가져오기
        FlashMap outputFlashMap = RequestContextUtils.getOutputFlashMap(request);
        outputFlashMap.put("message", "플래시 속성이 설정되었습니다!");
        if (flashMapManager != null) {
            flashMapManager.saveOutputFlashMap(outputFlashMap, request, response);  // FlashMapManager를 통해 FlashMap 을 세션에 저장
        }
        return new RedirectView("/getFlashAttribute");
    }

    @GetMapping("/getFlashAttribute")
    public String getFlashAttribute(HttpServletRequest request, Model model) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);  // 입력 FlashMap을 가져옴
        if (inputFlashMap != null) {
            model.addAttribute("flashMessage", inputFlashMap.get("message"));
        } else {
            model.addAttribute("flashMessage", "플래시 속성이 없습니다.");
        }
        return "flashSuccess";
    }
}
