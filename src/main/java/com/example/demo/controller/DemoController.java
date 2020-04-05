package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.ResponeData;
import com.example.demo.model.User;


@Controller
public class DemoController {
	
	@Autowired
	private UserMapper userMapper;
	public DemoController(UserMapper UserMapper) {
		this.userMapper = UserMapper;
	}
	
	public DemoController() {
		System.out.print("dddddđsssssssssssssss");
	}

	@RequestMapping("/")
	public String index() {
		return "index.html";
	}

	@RequestMapping("/login")
	public String Login() {
		return "login";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	@PostMapping("/insertuser")
	public String insertuser(User user) {
		userMapper.insert(user);
		return "profile";
	}
	
	@PostMapping("/submitlogin")
	public ModelAndView SubmitLogin(@ModelAttribute("user") User user) {
		ModelAndView model = new ModelAndView("profile");
		model.addObject("user", user);
		return model;
	}
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable(value="id") int id, Model model) {
		User user = new User();
		user = userMapper.getById(id);
		model.addAttribute("user", user);
		return "userEdit";
	}
	
	@PostMapping("/ChangeUser")
	public String Update(User user) {
		userMapper.update(user);
		return "profile";
	}
	
	@GetMapping("/delete/{id}")
	public String DeleteUser(@PathVariable(value="id") int id) {
		userMapper.delete(id);
		return "profile";
	}
}
