package com.example.Boot_3_1_1.dao;



import com.example.Boot_3_1_1.model.User;

import java.util.List;

public interface UserDao {
    List<User> index();

    User show(int id);

    void save(User user);

    void update(int id, User user);

    void delete(int id);

}
