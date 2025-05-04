package hello.hellobasic;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ConsumesProducesController {

    @RequestMapping(value = "/consumes", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String saveReport() {
        return "Consumes";
    }

    @RequestMapping(value = "/produces", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String getReport() {
        return "Produces";
    }
}