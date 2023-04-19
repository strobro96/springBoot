package ru.stroich.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.stroich.springboot.model.User;
import ru.stroich.springboot.service.UserService;


import java.util.List;

@Controller
@RequestMapping("/table")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(ModelMap model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "table";
    }

    @GetMapping("/addUser")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "user-info";
    }

    @PostMapping()
    public String addNewUser(@ModelAttribute("user") User user) {
        if (user.getId() == null) {
            userService.saveUser(user);
        }
        userService.updateUser(user);
        return "redirect:/table";
    }

    @PatchMapping("/update/{id}")
    public String updateUser(ModelMap model, @PathVariable("id") Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-info";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/table";
    }

}
