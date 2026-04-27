package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

//user information controller

@Controller
public class UserController {
	// user information

	@Autowired
	UserService userService;

	// ユーザー情報一覧画面を表示
	@GetMapping("/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/list";

	}

	// ユーザーの新規登録画面を表示
	@GetMapping("/user/add")
	public String displayAdd(Model model) {
		return "user/add";
	}

	// ユーザー詳細画面の表示
	@GetMapping("/user/{id}")
	public String displayView(@PathVariable("id") Long id, Model model) {

		User user = userService.findById(id);

		if (user == null) {
			return "user/list";
		}

		model.addAttribute("userData", user);
		return "user/view";
	}

	// ユーザー新規登録画面
	@RequestMapping(value="/user/create", method = RequestMethod.Post)
	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		
	if(result.hasError()) {
		//入力チェックエラーの場合
		List<String>errorList = new ArrayList<>();
		for (ObjectError error : result.getAllErrors()) {
			errorList.add(error.getDefaultMessage());
		}
		model.addAttribute("validationError", errorList);
		return"user/add";
		
	}
	//ユーザー情報の登録
	userService.create(userRequest);
	return "redirect:/user/list;
		
	}
}
