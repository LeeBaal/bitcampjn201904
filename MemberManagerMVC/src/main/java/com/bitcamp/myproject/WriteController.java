package com.bitcamp.myproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WriteController {
	
	@RequestMapping("/write/writeForm")
	public String getwriteForm() {
		return "write/writeForm";
	}
	
}
