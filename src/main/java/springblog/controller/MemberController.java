package springblog.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springblog.dto.MemberForm;
import springblog.exception.member.MemberDuplicateException;
import springblog.exception.member.MemberException;
import springblog.model.Member;
import springblog.service.MemberService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String signUpFrom(Model model) {

        model.addAttribute("memberForm", new MemberForm());

        return "members/signUpForm";
    }

    @PostMapping("/members/new")
    public String signUp(@Valid MemberForm form, BindingResult result, Model model) {

        if (result.hasErrors()) {
            log.info("result={}", result);
            // 폼 다시 보여주면서 에러 출력
            return "members/signUpForm";
        }

        try {
            memberService.join(form);

        } catch (MemberDuplicateException e){
            log.error("{} : {}", e.getMessage(), e.getDuplicateData());
            result.reject("duplicateMember", e.getMessage());
            return "members/signUpForm";
        }

        return "redirect:/";
    }



}
