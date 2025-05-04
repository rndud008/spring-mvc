package hello.hellobasic;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MapController {

    @GetMapping("/map")
    public String map(@RequestParam Map<String, String> params) {  // 모든 요청 파라미터를 Map으로 처리
        return "받은 파라미터: " + params.toString();
    }

    @GetMapping("/multivalueMap")
    public String multiValueMap(@RequestParam MultiValueMap<String, String> params) {  // MultiValueMap으로 처리
        return "받은 파라미터: " + params.toString();
    }
}