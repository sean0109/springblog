package springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springblog.dto.memberForm;

@Controller
public class MemberController {


    @GetMapping("/signup")
    public String signup(Model model) {

        model.addAttribute("memberForm", new memberForm());

        return "signup";
    }

}
