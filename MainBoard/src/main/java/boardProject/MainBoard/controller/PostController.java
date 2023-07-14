package boardProject.MainBoard.controller;

import boardProject.MainBoard.domain.Post;
import boardProject.MainBoard.domain.PostTag;
import boardProject.MainBoard.domain.Tag;
import boardProject.MainBoard.domain.User;
import boardProject.MainBoard.service.PostService;
import boardProject.MainBoard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService=postService;
    }


    @GetMapping("/postSubmit")
    public String PostSave(@RequestParam("date") int date,@RequestParam("name") String name,@RequestParam("postTage") PostTag postTag,
                           @RequestParam("data") String data,@RequestParam("userId")String userId,
                           @RequestParam("userName") String userName,@RequestParam("tag") Tag tag){
        Post post= new Post(date, name, data, userId, tag, postTag, userName);
        postService.addPost(post);
        return "redirect:/main";
    }

    @GetMapping("/post/posting")
    public String posting(){
        return "posting";
    }
    @GetMapping("/post/post")
    public String showPost(Model model,Long code){
        List<Post> list=postService.findByPostTag(PostTag.all);

        model.addAttribute("list",list);

        return "post";
    }

    @GetMapping("/post/humorPost")
    public String humorPost(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size,Model model){
        Pageable pageable= PageRequest.of(page,size);
        //Page<Post> humorList=postService.findByPostTag(PostTag.humor);

        model.addAttribute("postList",postService.findByPostTag(PostTag.hummor));

        return  "post/humorPostList";
    }


}
