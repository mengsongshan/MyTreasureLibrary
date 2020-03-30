package com.water.entitys;

import lombok.Data;

@Data
public class User extends AbstractEntity {

    private String name;

    private String nickName;

    private String password;
}
