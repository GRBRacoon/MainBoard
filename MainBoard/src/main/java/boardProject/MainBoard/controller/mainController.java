package boardProject.MainBoard.controller;
import boardProject.MainBoard.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class mainController {
    @GetMapping("/main")
    public String main(Model model, User user) {
        model.addAttribute(user);

        return "main";
    }
}