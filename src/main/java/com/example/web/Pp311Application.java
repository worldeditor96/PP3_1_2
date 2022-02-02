package com.example.web;

import com.example.web.Service.UserService;
import com.example.web.Service.UserServiceImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pp311Application {

    public static void main(String[] args) {
        SpringApplication.run(Pp311Application.class, args);

//        userServiceImpl.saveUser("Valli", "Kotikov", (byte) 45);
//        userServiceImpl.saveUser("Irina", "Shemeleva", (byte) 25);
//        userServiceImpl.saveUser("Maxim", "Penza", (byte) 543);
//        userServiceImpl.saveUser("Klod", "Jonson", (byte) 34);

//        UserService userServiceImpl=new UserServiceImpl();
//
//
//        userServiceImpl.save("Valli", "Kotikov", (byte) 45);
//        userServiceImpl.save("Irina", "Shemeleva", (byte) 25);
//        userServiceImpl.save("Maxim", "Penza", (byte) 543);
//        userServiceImpl.save("Klod", "Jonson", (byte) 34);
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        Session session = Util.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        User user = new User(name, lastName, age);
//        session.save(user);
//        transaction.commit();
//        session.close();
//    }

    }
}
