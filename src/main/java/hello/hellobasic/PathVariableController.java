package hello.hellobasic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

    @GetMapping("/projects/{project}")
    public String getProject(@PathVariable("project") String project) {
        return "프로젝트 명: " + project + " 정보를 표시합니다.";
    }

    @PostMapping("/projects/{project}/versions/{version}")
    public String getProjectVersions(@PathVariable("project") String project, @PathVariable("version") String version) {
        return "프로젝트 명: " + project + ", Version: " + version + " 정보를 표시합니다.";
    }

    @GetMapping("/projects/{projectId:[a-z]+}/details")
    public String getProjectDetails(@PathVariable("projectId") String projectId) {
        return "Project ID: " + projectId;
    }

    @GetMapping("/users/{userId}")
    public String getUserId(@PathVariable String userId) {
        return "사용자 ID: " + userId + " 정보를 표시합니다.";
    }
}