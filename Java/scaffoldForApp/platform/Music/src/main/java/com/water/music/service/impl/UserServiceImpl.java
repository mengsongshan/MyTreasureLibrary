package com.water.music.service.impl;

import com.water.music.dao.UserDao;
import com.water.music.service.UserService;
import com.water.music.servicebean.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public
class UserServiceImpl implements UserService{

    private  static final
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private
    UserDao userDao;

    @Override
    public
    void addUser(User user) {
        logger.debug("enter insert user ");
        userDao.addUser(user);
    }

    public
    void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
