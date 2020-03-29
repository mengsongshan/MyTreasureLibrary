package com.water.music.entity.userinfo;

import java.util.List;

public
class User {
    private long id;
    private String name ;
    private String nickName ;
    private int age;
    private String sex;
    private List<Contract> contracts;
    private List<Address> addresses;
    private List<Job> jobs;
    private List<Hobby> hobbys;
    private List<Company> companies;
    private List<Picture> pictures;

    public
    List<Picture> getPictures() {
        return pictures;
    }

    public
    void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public
    long getId() {
        return id;
    }

    public
    void setId(long id) {
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
    String getNickName() {
        return nickName;
    }

    public
    void setNickName(String nickName) {
        this.nickName = nickName;
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
    String getSex() {
        return sex;
    }

    public
    void setSex(String sex) {
        this.sex = sex;
    }

    public
    List<Contract> getContracts() {
        return contracts;
    }

    public
    void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public
    List<Address> getAddresses() {
        return addresses;
    }

    public
    void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public
    List<Job> getJobs() {
        return jobs;
    }

    public
    void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public
    List<Hobby> getHobbys() {
        return hobbys;
    }

    public
    void setHobbys(List<Hobby> hobbys) {
        this.hobbys = hobbys;
    }

    public
    List<Company> getCompanies() {
        return companies;
    }

    public
    void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public
    String toString() {
        return "User{" + "name='" + name + '\'' + ", nickName='" + nickName + '\'' + ", age=" + age + ", sex='" + sex + '\'' + ", contracts=" + contracts + ", addresses=" + addresses + ", jobs=" + jobs + ", hobbys=" + hobbys + ", companies=" + companies + '}';
    }
}
