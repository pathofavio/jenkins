package com.tesco.tescospringweb.controller;

import com.tesco.tescospringweb.service.UserServiceImpl;
import model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/mainapp")
public class AppController {

    @Autowired
    UserServiceImpl service;
    ArrayList<UserDetails> usrList = new ArrayList<>();
    ArrayList<String> users = new ArrayList<>();

//    @RequestMapping(path = "/welcome", method = RequestMethod.GET)
//    @ResponseBody
//    public String sayWelcome(){
//        return "Welcome to Spring app.";
//    }

//    @RequestMapping(path = "/login", method = RequestMethod.GET)
//    //@ResponseBody
//    public String loginPage(){
//        return "login";
//    }


//    @RequestMapping(path = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public String loginUsr(@RequestParam("uname")String uname, @RequestParam("pass")String pass) {
//        if(uname.equals("admin") && pass.equals("manager")){
//            return "Login Successfully.";
//        }
//        return "Failure login!";
//    }


    @PostMapping("/login")
    public String loginUsr(@ModelAttribute UserDetails userDetails) {
        if(service.userLogin(userDetails.getUname(), userDetails.getPass())){
            return "Login Successfully.";
        }
        return "Failure login!";
    }

//    @RequestMapping(path = "/registration", method = RequestMethod.GET)
//    //@ResponseBody
//    public String registrationPage(){
//        return "registration";
//
//    }

//    @RequestMapping(path = "/registration", method = RequestMethod.POST)
//    @ResponseBody
//    public String registrationUsr(){
//        return "Registration completed successfully.";
//    }

//    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    @PostMapping("/registration")
    public List<UserDetails> registrationUsr(@ModelAttribute UserDetails usr){
        service.addUser(usr);
        return usrList;
    }

    @GetMapping("/loadAll")
    public List<UserDetails> loadAll(){

        System.out.println(service.loadUsers());
        return service.loadUsers();
    }

    @GetMapping("/findUser/{uname}")
    public String findUser(@PathVariable String uname) {
            if(service.findUser(uname)) {
            return uname + " found....!";
            }
            return "user not found..!";
    }

    @DeleteMapping("/deleteUser/{uname}")
    public String deleteUser(@PathVariable String uname) {
        if(service.deleteUser(uname)) {
            return uname + " deleted....!";
        }
        return "user not found..!";
    }

    @PutMapping("/updateuser/{uname}")
    public String updateUser(@PathVariable String uname, @RequestBody UserDetails usr){
        if(service.updateUser(uname, usr)){
            return "User "+uname+"updated successfully.";
        }
        return "User "+uname+" Not updated successfully.";
    }

}
