package com.eternity.services.users;

import com.eternity.services.users.bean.UserReq;
import com.eternity.services.users.bean.UserResp;

public
interface UserProvider {

    /**
     * 根据userID获取用户详细信息
     * @param req
     * @return
     */
     UserResp getUserInfoDetail(UserReq req);

}
