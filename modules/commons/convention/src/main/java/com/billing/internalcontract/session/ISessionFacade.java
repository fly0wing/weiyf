package com.billing.internalcontract.session;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.UserSession;

/**
 * 会话服务：直接通过Shiro框架提供的API来提供会话服务即可？org.apache.shiro.SecurityUtils
 * Created by xiaoyouyi on 2014-8-26.
 */
public interface ISessionFacade {

    /**
     * 根据会话标识获取指定的会话。
     * longReq，会话标识
     * longReq2,0表示仅限当前有效的会话，1表示以失效时需要从会话持久化库中获取
     * @param req
     * @return 结果存放在objResult中
     */
    BaseResp getBySessionId(BaseReq req);

    /**
     * 根据会话标识获取指定的会话。
     * stringReq，表示待查找的会话令牌
     * @param req
     * @return 结果存放在objResult中
     */
    BaseResp getBySessionToken(BaseReq req);
}
