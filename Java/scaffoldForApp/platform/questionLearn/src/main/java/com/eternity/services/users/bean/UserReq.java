package com.eternity.services.users.bean;

import java.io.Serializable;
import java.util.List;

public
class UserReq implements Serializable{
    private String id;
    private String name;
    private String age;
    private String sex;
    private
    List<String> ext;

    public
    List<String> getExt() {
        return ext;
    }

    public
    void setExt(List<String> ext) {
        this.ext = ext;
    }

    public
    String getId() {
        return id;
    }

    public
    void setId(String id) {
        this.id = id;
    }

    public
    String getName() {
        return name;
    }

    public
    void setName(String name) {
        this.name = name;
    }

    public
    String getAge() {
        return age;
    }

    public
    void setAge(String age) {
        this.age = age;
    }

    public
    String getSex() {
        return sex;
    }

    public
    void setSex(String sex) {
        this.sex = sex;
    }
}
