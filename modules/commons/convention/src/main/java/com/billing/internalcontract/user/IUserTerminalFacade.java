package com.billing.internalcontract.user;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.user.orm.business_model.TerminalInfo;

import java.util.List;

/**
 * 用户终端接口
 * Created by xiaoyouyi on 2014-8-23.
 */
public interface IUserTerminalFacade {

    /**
     * 绑定当前用户终端，无需传入待绑定的终端，从当前会话中获取。
     * @param req
     * @return
     */
    BaseResp activeTerminal(TerminalActiveReq req);

    /**
     * 绑定当前用户终端，无需传入待绑定的终端，从当前会话中获取。
     * @param req
     * @return
     */
    BaseResp bindTerminal(TerminalBindReq req);

    /**
     * 获取用户当前绑定的终端列表，主要是终端标识、指纹和名称信息
     * @param req
     * @return
     */
    BaseResp getBoundTerminals(BaseReq req);

    /**
     * 解绑用户终端，输入需要待解除绑定的终端标识和指纹
     * @param req
     * @return
     */
    BaseResp unbindTerminal(TerminalUnbindReq req);

    /**
     * 根据终端指纹获取终端
     * @param req
     * @return
     */
    BaseResp<List<TerminalInfo>> getTerminalByFingerprint(BaseReq req);



}
