package com.example.frontendservice.controller;


import com.example.frontendservice.model.User;
import com.example.frontendservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("front")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/showUser")
    public String ShowUser(Model model, @Param("keyword") String keyword){
        if(keyword!=null) {
            List<User> listUsers = userService.getByKeyword(keyword);
            model.addAttribute("listUsers", listUsers);
        }else {
            List<User> listUsers = userService.getUsers();
            model.addAttribute("listUsers", listUsers);}
        return "User";
    }
    @GetMapping("/addUser")
    public String AddUser(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "AddUser";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User product) {
        userService.saveUser(product);
        return "redirect:/front/showUser";

    }
    @GetMapping("/editUser/{id}")
    public String updateUser(@PathVariable (value = "id") int id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "AddUser";

    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") int id){
        userService.deleteUser(id);
        return "redirect:/front/showUser";
    }
}
