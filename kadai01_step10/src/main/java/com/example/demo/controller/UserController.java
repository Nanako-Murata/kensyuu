package com.example.demo.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.dto.*;

@Controller
public class UserController {

	// ユーザーの新規登録画面を表示
	@RequestMapping(value="/user/add", method=RequestMethod.GET)
	public String displayAdd(Model model) {
		model.addAttribute("userRequest", new UserRequest);
		return "user/add";
	}

	// ユーザーの新規登録
	@RequestMapping(value = "user/create", method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "user/add";
		}
	}
}