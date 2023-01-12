package ru.fadeev.pp_3_1_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fadeev.pp_3_1_2.model.User;
import ru.fadeev.pp_3_1_2.service.UserService;


@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getUsersList());
        return "users";
    }

    @GetMapping("/new")
    public String getFormToAddNewUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String getFormToUpdateUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/edit/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/edit/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
