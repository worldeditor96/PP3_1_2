package com.example.web.Service;

import com.example.web.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> index();
    User show(int id);
    void save(User user);
    void update(int id, User updatePerson);
    void delete(int id);

    void addUser(User user);

    //void saveUser(String name, String lastName, byte age) throws SQLException;

}
