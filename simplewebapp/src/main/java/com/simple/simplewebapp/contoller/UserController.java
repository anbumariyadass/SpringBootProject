package com.simple.simplewebapp.contoller;


import com.simple.simplewebapp.entity.User;
import com.simple.simplewebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(User user) {
        userService.registerUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(String username, String password, Model model) {
		
		 User user = userService.loginUser(username, password); 
		 if (user != null) {
			 return "redirect:/welcome"; 
		 }
		 
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}
