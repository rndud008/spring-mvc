package hello.hellobasic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @GetMapping("/project/{projectName}/versions/{version}")
    public String project(@PathVariable("projectName") String projectName, @PathVariable("version") String version) {
        return projectName + ": " + version;
    }
}