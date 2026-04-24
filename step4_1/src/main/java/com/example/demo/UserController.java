package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/list")
  public String displayList(Model model) {

    List<User> userlist = userService.searchAll();

    // ❗キー名は普通の名前にする
    model.addAttribute("userlist", userlist);

    // ❗templates/user/list.html を表示する
    return "list";
  }
}