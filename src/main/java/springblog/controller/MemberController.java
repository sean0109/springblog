package springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springblog.dto.MemberForm;

@Controller
public class MemberController {


    @GetMapping("/signup")
    public String signup(Model model) {

        model.addAttribute("memberForm", new MemberForm());

        return "signup";
    }

}
