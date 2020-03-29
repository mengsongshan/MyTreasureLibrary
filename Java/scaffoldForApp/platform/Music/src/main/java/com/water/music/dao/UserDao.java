package com.water.music.dao;

import com.water.music.servicebean.user.User;

import java.util.List;

public
interface UserDao {
     void addUser(User user);

     void updateUser(User user);

     void removeUser(User user);

     User queryUser(User user);

     List<User> queryUsersById(int id);

}
