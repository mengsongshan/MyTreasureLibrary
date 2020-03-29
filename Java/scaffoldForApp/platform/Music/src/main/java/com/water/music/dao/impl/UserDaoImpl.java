package com.water.music.dao.impl;

import com.water.music.dao.UserDao;
import com.water.music.servicebean.user.User;
import com.water.music.util.JdbcPool;
import com.water.music.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public
class UserDaoImpl implements UserDao {
private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public void addUser(User user) {
        Connection con = JdbcUtil.getJdbcUtil("mysql").getConnection();
        try {
            con.setAutoCommit(false);
            long beginTime = System.currentTimeMillis();
            PreparedStatement ps = con.prepareStatement("insert into m_user (id,createtime,name,nickName,sex,age) values (?,?,?,?,?,?);");
            ps.setInt(1,user.getId());
            ps.setDate(2,user.getCreateTime());
            ps.setString(3,user.getName());
            ps.setString(4,user.getNickName());
            ps.setString(5,user.getSex());
            ps.setInt(6,user.getAge());
            ps.execute();

            con.commit();
            logger.debug(Thread.currentThread().getName()+"--------------------------"+(System.currentTimeMillis()-beginTime)+"ms");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

        }
    }

    @Override
    public
    void updateUser(User user) {

    }

    @Override
    public
    void removeUser(User user) {

    }

    @Override
    public
    User queryUser(User user) {

        return null;
    }

    @Override
    public
    List<User> queryUsersById(int id) {
        return null;
    }
}
