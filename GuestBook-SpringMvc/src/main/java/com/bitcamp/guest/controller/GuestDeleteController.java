package com.bitcamp.guest.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.domain.RequestGuestWrite;
import com.bitcamp.guest.service.DeleteMessageService;
import com.bitcamp.guest.service.InvalidMessagePasswordException;
import com.bitcamp.guest.service.MessageNotFoundException;

@Controller
public class GuestDeleteController {
	
	@Autowired
	private DeleteMessageService deleteService;
	
	
	@RequestMapping("/guest/deleteForm")
	public String getdeleForm() {
		
		return "guest/deleteForm";
	}
	
	@RequestMapping(value = "guest/delete", method = RequestMethod.POST)
	public String delete(@RequestParam(value = "password") String password,
			@RequestParam(value = "messageId") int id,
			Model model) {
		
		
		boolean chk = false;
		int rCnt = 0;
		String msg = null;
		
		try {
			rCnt = deleteService.deleteMessage(id, password);
			chk = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		} catch (MessageNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		} catch (InvalidMessagePasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = e.getMessage();
		}
		
		model.addAttribute("resultCnt", rCnt);
		model.addAttribute("chk", chk);
		model.addAttribute("msg", msg);
		
		return "guest/delete";
	}
}
