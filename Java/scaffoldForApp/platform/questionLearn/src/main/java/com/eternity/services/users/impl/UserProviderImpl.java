package com.eternity.services.users.impl;

import com.eternity.services.users.bean.UserReq;
import com.eternity.services.users.bean.UserResp;
import com.eternity.services.users.UserProvider;

public
class UserProviderImpl implements UserProvider {

    @Override
    public
    UserResp getUserInfoDetail(UserReq userId) {
        UserResp ur = new UserResp();
        ur.setMsg("success !");
        ur.setResult("......");
        return ur;
    }
}
