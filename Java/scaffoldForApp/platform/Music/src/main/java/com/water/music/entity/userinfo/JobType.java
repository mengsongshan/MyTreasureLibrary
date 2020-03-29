package com.water.music.entity.userinfo;

public
class JobType {
    private int id;
    private String name;
    private JobType parent;

    public
    JobType(String name, JobType parent) {
        this.name = name;
        this.parent = parent;
    }

    public
    JobType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public
    JobType() {
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
    String getName() {
        return name;
    }

    public
    void setName(String name) {
        this.name = name;
    }

    public
    JobType getParent() {
        return parent;
    }

    public
    void setParent(JobType parent) {
        this.parent = parent;
    }

    @Override
    public
    String toString() {
        return "JobType{" + "name='" + name + '\'' + ", parent=" + parent + '}';
    }
}
