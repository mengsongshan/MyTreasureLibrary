package com.eternity.services.users.bean;

import java.io.Serializable;

public
class UserResp implements Serializable{
    private String result;
    private String msg;

    public
    String getResult() {
        return result;
    }

    public
    void setResult(String result) {
        this.result = result;
    }

    public
    String getMsg() {
        return msg;
    }

    public
    void setMsg(String msg) {
        this.msg = msg;
    }
}
