package hello.hellobasic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class HttpInterfaceController {

    private final PostService postService;

    @GetMapping("/form")
    public String postForm() {

        return "postForm";
    }

    @PostMapping
    public String createPost(@ModelAttribute Post post) {
        postService.createPost(post);

        return "redirect:/posts";
    }

    @GetMapping("/{id}")
    public String getPost(@PathVariable("id") int id,  Model model) {

        Post post = postService.getPostById(id);
        model.addAttribute("post", post);

        return "post";
    }

    @GetMapping
    public String getPostAll(Model model) {

        List<Post> posts = postService.getPosts();
        model.addAttribute("posts", posts);

        return "posts";
    }
}
