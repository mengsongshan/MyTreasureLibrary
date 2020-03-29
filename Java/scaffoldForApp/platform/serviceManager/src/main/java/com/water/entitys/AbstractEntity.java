package com.water.entitys;

import java.util.Date;


public
class AbstractEntity {

    /**
     * UUID
     */
    protected String uuid;

    /**
     * 创建者
     */
    protected String creator;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 更新者
     */
    protected String updator;

    /**
     * 更新时间
     */
    protected Date updateTime;
}
