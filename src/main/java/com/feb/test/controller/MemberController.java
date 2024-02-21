package com.feb.test.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.feb.test.servise.MemberServise;

@Controller
public class MemberController {

	@Autowired
	MemberServise memberservise;
	
	// 회원가입 페이지 : /join.do
	@GetMapping("/index.do")
	public ModelAndView loginform() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	
	/*
	        회원 가입
	    memberId : 아이디
	    passwd : 비밀번호
	    passwd2 : 비밀번호 재확인
	*/
	@PostMapping("/join.do")
	public ModelAndView join(@RequestParam HashMap<String, String> params) {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("memberId : " + params.get("memberId")); // memberId : s123s123s
		System.out.println("passwd : " + params.get("passwd")); // 123
		System.out.println("passwd2 : " + params.get("passwd2")); // 123
		
		int result = memberservise.join(params);
		
		if(result == 1) {
			mv.addObject("resultMsg", "회원가입 성공");
		}else {
			mv.addObject("resultMsg", "비밀번호가 같이 않아서 회원가입에 실패하였습니다");
		}
		
		mv.setViewName("home");
		return mv;
	}
}



