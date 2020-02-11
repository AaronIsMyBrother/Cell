package com.aaron.dao;

import com.aaron.bean.User;

import java.util.Collection;

public interface D {

    public Collection<User> getAll();

    public void addUser(User user);

    public void deleteUser(String name);

    public void updateUser(String name);
}
