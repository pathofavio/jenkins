package com.tesco.tescospringweb.service;

import model.UserDetails;

import java.util.List;

public interface UserService {
    public void addUser(UserDetails userDetails);
    public boolean userLogin(String uname, String pass);
    public List<UserDetails> loadUsers();
    public boolean findUser(String uname);
    public boolean deleteUser(String uname);
    public boolean updateUser(String uname, UserDetails usr);
}
