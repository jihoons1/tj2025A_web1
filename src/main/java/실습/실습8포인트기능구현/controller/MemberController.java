package 실습.실습8포인트기능구현.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 실습.실습8포인트기능구현.model.dto.MemberDto;
import 실습.실습8포인트기능구현.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired private MemberService memberService;


    // 회원가입
    @PostMapping("/new")
    public int sign(MemberDto dto){
        int resunt = memberService.sign(dto);
        return resunt;
    }

    // 로그인
    @GetMapping("/login")
    public int login ( MemberDto dto){
        int re = memberService.login(dto);
        return re;
    }

}
