package com.example.web.controller;

import com.example.web.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.web.Service.RoleService;
import com.example.web.Service.UserService;
import com.example.web.models.User;


@Controller
@RequestMapping("/admin")
public class AdminController {


    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping()
    public String index(Model model, Authentication authentication) {
        model.addAttribute("people", userService.index());
        User user = (User) authentication.getPrincipal();
        model.addAttribute("user", user);
        return "admin/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));

        return "admin/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user, @RequestParam("roles") String[] rolesNames) {
        user.setRoles(roleService.getSetOfRoles(rolesNames));
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "admin/edit";

    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }

}
