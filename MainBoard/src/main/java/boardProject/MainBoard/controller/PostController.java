package boardProject.MainBoard.controller;

import boardProject.MainBoard.service.PostService;
import boardProject.MainBoard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService=postService;
    }
}
