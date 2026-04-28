package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	// ユーザー情報
	@Autowired
	private UserService userService;

	// ユーザー情報検索画面を表示

	@GetMapping(value = "/user/search")
	public String displaySearch(Model model) {
		model.addAttribute("userSearchRequest", new UserSearchRequest());
		return "user/search";

	}

	// ユーザー情報検索
	@PostMapping("/user/id_search")
	public String search(@ModelAttribute UserSearchRequest usr, Model model) {

		System.out.println("ID = " + usr.getId());

		User user = userService.search(usr);
		model.addAttribute("userinfo", user);

		return "user/search";
	}
}