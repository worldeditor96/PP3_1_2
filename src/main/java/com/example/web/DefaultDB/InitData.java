package com.example.web.DefaultDB;

import com.example.web.models.Role;
import com.example.web.models.User;
import com.example.web.Service.RoleService;
import com.example.web.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitData {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitData(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void insertData() {

        roleService.saveRole(new Role("ROLE_ADMIN"));
        roleService.saveRole(new Role("ROLE_USER"));

        Set<Role> rolesAdmin = new HashSet<>();
        rolesAdmin.add(roleService.getRoleByName("ROLE_USER"));
        rolesAdmin.add(roleService.getRoleByName("ROLE_ADMIN"));

        User admin = new User();
        admin.setUsername("admin");
        admin.setLastName("admin");
        admin.setAge(4);
        admin.setPassword("admin");
        admin.setRoles(rolesAdmin);
        userService.addUser(admin);

        Set<Role> rolesUser = new HashSet<>();
        rolesUser.add(roleService.getRoleByName("ROLE_USER"));

        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setLastName("user");
        user.setAge(8);
        user.setRoles(rolesUser);
        userService.addUser(user);

        Set<Role> roles1 = new HashSet<>();
        roles1.add(roleService.getRoleByName("ROLE_USER"));
        roles1.add(roleService.getRoleByName("ROLE_ADMIN"));

        User number1 = new User();
        number1.setUsername("1");
        number1.setPassword("1");
        number1.setLastName("1");
        number1.setAge(1);
        number1.setRoles(roles1);
        userService.addUser(number1);


        Set<Role> roles2 = new HashSet<>();
        roles2.add(roleService.getRoleByName("ROLE_USER"));

        User number2 = new User();
        number2.setUsername("2");
        number2.setPassword("2");
        number2.setLastName("2");
        number2.setAge(2);
        number2.setRoles(roles2);
        userService.addUser(number2);

    }
}
