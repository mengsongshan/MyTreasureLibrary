package com.water.music.controller;

import com.water.music.service.UserService;
import com.water.music.servicebean.user.User;

import java.util.List;

public
class UserController {
    private
    UserService userService;

    UserController(){

    }

    public void addUser(User user){
        userService.addUser(user);
    }

    public List<User> queryUserByID(){

        return null;
    }

    public
    void setUserService(UserService userService) {
        this.userService = userService;
    }
}
