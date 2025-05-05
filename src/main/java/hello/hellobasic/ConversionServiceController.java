package hello.hellobasic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConversionServiceController {

    @Autowired
    private DefaultConversionService conversionService;

    @PostMapping("/url")
    @ResponseBody
    public String url(@ModelAttribute("url") Url url) {
        String result = conversionService.convert(url, String.class);
        return "URl : " + result;
    }

    @GetMapping("/url")
    @ResponseBody
    public Url url(@RequestParam("url") String url) {
        return conversionService.convert(url, Url.class);
    }
}