package hello.hellobasic.converter;

import hello.hellobasic.StringToIntegerConverter;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ConverterController {

    private final StringToUrlConverter stringToUrlConverter  = new StringToUrlConverter();
    private final UrlToStringConverter urlToStringConverter = new UrlToStringConverter();

    @GetMapping("/url")
    @ResponseBody
    public String getUrl(@RequestParam("url") String url){
        Url result = stringToUrlConverter.convert(url);
        log.info("url: {}",result);
        return "Url: " + result;
    }

    @PostMapping("/url")
    @ResponseBody
    public String getUrl(@ModelAttribute("url") Url url){
        String result = urlToStringConverter.convert(url);
        log.info("url: {}", result );

        return "Url: " + result;
    }
}