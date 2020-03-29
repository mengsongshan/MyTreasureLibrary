package com.water.music.entity.userinfo;

public
class Picture {
    private int id;
    private String url;
    private String type;

    public
    int getId() {
        return id;
    }

    public
    void setId(int id) {
        this.id = id;
    }

    public
    String getUrl() {
        return url;
    }

    public
    void setUrl(String url) {
        this.url = url;
    }

    public
    String getType() {
        return type;
    }

    public
    void setType(String type) {
        this.type = type;
    }

    @Override
    public
    String toString() {
        return "Picture{" + "id=" + id + ", url='" + url + '\'' + ", type='" + type + '\'' + '}';
    }
}
