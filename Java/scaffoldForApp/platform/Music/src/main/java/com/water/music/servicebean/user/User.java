package com.water.music.servicebean.user;

import java.sql.Date;

public
class User {

    public User(){

    }

    public
    User(int id, String name, String sex, int age, String nickName) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.nickName = nickName;
    }


    private int id;
    private String name ;

    private String sex;

    private int age;

    private String nickName;

    private Date createTime;

    public
    String getName() {
        return name;
    }

    public
    void setName(String name) {
        this.name = name;
    }

    public
    String getSex() {
        return sex;
    }

    public
    void setSex(String sex) {
        this.sex = sex;
    }

    public
    int getAge() {
        return age;
    }

    public
    void setAge(int age) {
        this.age = age;
    }

    public
    String getNickName() {
        return nickName;
    }

    public
    void setNickName(String nickName) {
        this.nickName = nickName;
    }


    public
    int getId() {
        return id;
    }

    public
    void setId(int id) {
        this.id = id;
    }


    public
    Date getCreateTime() {
        return createTime;
    }

    public
    void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
