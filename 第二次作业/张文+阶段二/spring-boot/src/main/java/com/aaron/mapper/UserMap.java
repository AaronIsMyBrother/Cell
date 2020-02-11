package com.aaron.mapper;

import com.aaron.bean.User;

public interface UserMap {

    public User getUserByName(String name);

    public void insertUser(User user);
}
