package com.bitcamp.myproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.model.MemberInfo;

@Controller
public class RegiController {
	
	@RequestMapping(value = "/member/memberRegForm", method = RequestMethod.GET)
	public String getmemberRegForm() {
		return "member/memberRegForm";
	}
	
	@RequestMapping(value = "/member/memberRegProcess",method = RequestMethod.POST)
	public String getmemberRegProc(MemberInfo member) {
		
		
		return "member/memberRegProcess";
	}
	
	
	
}
