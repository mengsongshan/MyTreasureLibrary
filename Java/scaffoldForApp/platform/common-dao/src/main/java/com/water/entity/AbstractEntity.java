package com.water.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class AbstractEntity implements Serializable {

    private String uuid;

    private Date createTime;

    private Date updateTime;

    private String creator;

    private String updater;

}
