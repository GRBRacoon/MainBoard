package boardProject.MainBoard.controller;

import boardProject.MainBoard.domain.Post;
import boardProject.MainBoard.domain.PostTag;
import boardProject.MainBoard.service.PostService;
import boardProject.MainBoard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService=postService;
    }

    @GetMapping("Post")
    public String showPost(Model model,Long code){
        Post post= postService.findByPostCode(code);
        model.addAttribute("post",post);
        return "post";
    }


}
