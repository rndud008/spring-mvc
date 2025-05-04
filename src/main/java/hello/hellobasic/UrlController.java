package hello.hellobasic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/profile") // 타입 수준 매핑
@RequestMapping("/${profile_path}") // 플레이스홀더 사용
public class UrlController {

    @RequestMapping
    public String profile() {
        return "Profile";
    }
    @RequestMapping({"/user/**", "/mypage"})
    public String antAndMulti() {
        return "User or MyPage Profile";
    }

    @RequestMapping({"/view"})
    public String viewProfile() {
        return "View Profile";
    }

    @RequestMapping({"/edit"})
    public String editProfile() {
        return "Edit Profile";
    }

}