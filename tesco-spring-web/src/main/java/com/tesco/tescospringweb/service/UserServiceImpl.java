package com.tesco.tescospringweb.service;

import model.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    ArrayList<UserDetails> usrList = new ArrayList<>();
    @Override
    public void addUser(UserDetails userDetails) {

        usrList.add(userDetails);
        System.out.println(userDetails);
    }


    @Override
    public boolean userLogin(String uname, String pass) {

        if(uname.equals("admin") && pass.equals("manager")){
            return true;
        }
        return false;
    }

    @Override
    public List<UserDetails> loadUsers() {
        return usrList;
    }

    @Override
    public boolean findUser(String uname) {
        for(UserDetails usr:usrList) {
            if(usr.getUname().equals(uname)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(String uname) {
        for(UserDetails usr:usrList) {
            if(usr.getUname().equals(uname)) {
                usrList.remove(usr);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateUser(String name, UserDetails user) {
        for(UserDetails usr1 : usrList){
            if (usr1.getUname().equals(user.getUname())){
                usrList.remove(user);
                user.setCname(name);
                usrList.add(user);
                return true;
            }
        }
        return false;
    }

}
