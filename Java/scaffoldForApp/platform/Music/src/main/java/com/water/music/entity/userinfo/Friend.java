package com.water.music.entity.userinfo;

public
class Friend {
    private int id;
    private String name;

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

    @Override
    public
    String toString() {
        return "Friend{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
