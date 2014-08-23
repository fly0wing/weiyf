package com.billing.internalcontract.user;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;

/**
 * Created by xiaoyouyi on 2014-8-23.
 */
public interface IUserFacade {

    /**
     * 用户注册
     * @param req
     * @return
     */
    BaseResp register(RegisterReq req);


    /**
     * 用户登录
     * @param req
     * @return
     */
    BaseResp login(LoginReq req);


    /**
     * 绑定邮箱
     * @param req
     * @return
     */
    BaseResp bindEmail(BaseReq req);

    /**
     * 绑定手机号
     * @param req
     * @return
     */
    BaseResp bindPhone(BaseReq req);

    /**
     * 修改密码
     * @param req
     * @return
     */
    BaseResp changePassword(BaseReq req);

    /**
     * 检查登录名
     * @param req
     * @return
     */
    BaseResp checkLoginName(BaseReq req);

    /**
     * 检查登录名
     * @param req
     * @return
     */
    BaseResp checkLoginEmail(BaseReq req);

    /**
     * 检查登录名
     * @param req
     * @return
     */
    BaseResp checkLoginPhone(BaseReq req);




}
