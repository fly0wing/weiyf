package com.billing.internalcontract.user;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;

/**
 * Created by xiaoyouyi on 2014-8-23.
 */
public interface IUserFacade {

    /**
     * 用户注册，如果该终端上已经存在匿名注册的用户，直接绑定到该匿名用户上。
     * @param req
     * @return
     */
    BaseResp register(RegisterReq req);


    /**
     * 用户登录，确定会话中的用户标识
     * @param req
     * @return
     */
    BaseResp login(LoginReq req);

    /**
     * 用户登出，主动结束会话，会话从内存及缓存中移除。
     * @param req
     * @return void
     */
    void loginout(BaseReq req);

    /**
     * 绑定手机号，在绑定前需要调用requestActionToken方法，传入待绑定的手机号，请求发送actionToken；
     * 在用户输入收到的actionToken后，再调用本方法传入用户输入的actionToken，以及请求actionToken时的reuestGuid:atRequestGuid。
     * @param req
     * @return
     */
    BaseResp bindPhone(BaseReq req);

    /**
     * 修改密码:stringReq传入老的密码，stringReq2传入新的密码
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
    BaseResp checkLoginPhone(BaseReq req);

    /**
     * 请求操作口令，例如：绑定手机号时，需要请求发送验证短信。
     * @param req
     * @return
     */
    BaseResp requestActionToken(ActionTokenReq req);

    /**
     * 验证操作口令。
     * @param req
     * @return
     */
    BaseResp authActionToken(BaseReq req);

}
