package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users/allusers";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return ("users/takeuser");
    }

    @GetMapping("/addUser")
    public String addUser (ModelMap model) {
        model.addAttribute("user", new User());
        return ("/users/adduser");
    }

    @PostMapping()
    public String createUser (@ModelAttribute ("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser (@PathVariable ("id") long id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/users/edituser";
    }

    @PatchMapping("/{id}")
    public String updateUser (@ModelAttribute ("user") User user, @PathVariable ("id") long id) {
        userService.updateUser(id, user);
        return ("redirect:/users");
    }

    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable ("id") long id) {
        userService.deleteUser(id);
        return ("redirect:/users");
    }

}
