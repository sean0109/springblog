package springblog.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springblog.dto.MemberForm;

@Controller
public class MemberController {


    @GetMapping("/members/new")
    public String signUpFrom(Model model) {

        model.addAttribute("memberForm", new MemberForm());

        return "members/signupFrom";
    }

    @PostMapping("/signup")
    public String signUp(@Valid MemberForm memberForm, BindingResult bindingResult, Model model) {



        return null;
    }



}
