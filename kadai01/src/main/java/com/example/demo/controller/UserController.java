package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

//user information controller

@Controller
public class UserController {
	// ユーザー情報

	@Autowired
	UserService userService;

	// ユーザー情報一覧画面を表示
	@GetMapping("/user/list")
	public String displayList(Model model) {
		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		return "user/list";

	}

	// ユーザー新規登録画面
	@GetMapping("/user/add")
	public String displayAdd(Model model) {
	    model.addAttribute("userRequest", new UserRequest());
	    return "user/add";
	}
	//登録処理
	@PostMapping("/user/create")
	public String create(@Validated @ModelAttribute UserRequest userRequest,
	                     BindingResult result,
	                     Model model) {

	    if (result.hasErrors()) {
	        model.addAttribute("validationError", result.getAllErrors());
	        return "user/add";
	    }

	    userService.create(userRequest);
	    return "redirect:/user/list";
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

	// ユーザー編集画面
	@GetMapping("/user/{id}/edit")
	public String displayEdit(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
		userUpdateRequest.setId(user.getId());
		userUpdateRequest.setName(user.getName());
		userUpdateRequest.setPhone(user.getPhone());
		userUpdateRequest.setAddress(user.getAddress());
		model.addAttribute("userUpdateRequest", userUpdateRequest);
		return "user/edit";
	}

	// ユーザー更新
	@PostMapping("/user/update")
	public String update(
	        @Validated @ModelAttribute UserUpdateRequest uur,
	        BindingResult result,
	        Model model) {

	    if (result.hasErrors()) {

	        List<String> errorList = new ArrayList<>();
	        for (ObjectError error : result.getAllErrors()) {
	            errorList.add(error.getDefaultMessage());
	        }

	        model.addAttribute("validationError", errorList);

	        // 編集画面に戻す（GETと同じビュー）
	        return "user/edit";
	    }

	    // ユーザー情報の更新
	    userService.update(uur);

	    return "redirect:/user/" + uur.getId();
	}
}