package com.billing.user.facade;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.session.ISessionFacade;
import com.billing.user.facade.shiro.WyfBillingSecurityManager;
import com.billing.user.facade.shiro.WyfSession;
import com.billing.user.orm.dao.UserSessionDao;
import com.billing.user.orm.dao.UserSessionDurableDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionContext;
import org.apache.shiro.session.mgt.SessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaoyouyi on 2014-8-28.
 */
@Service
public class SessionFacade implements ISessionFacade {

    public static final String USER_SESSION = "userSession";

    @Autowired
    private UserSessionDao userSessionDao;

    @Autowired
    private UserSessionDurableDao userSessionDurableDao;

    /**
     * 创建会话：如SDK初始化联网时。
     *
     * @param req
     * @return 直接更新当前会话的会话标识？
     */
    @Override
    public BaseResp createSession(BaseReq req) {
        WyfSession wyfSession= (WyfSession)SecurityUtils.getSubject().getSession(true);

        SessionContext sessionContext = new DefaultSessionContext( );
        sessionContext.put( USER_SESSION,req.getSession() );
        Session session = WyfBillingSecurityManager.getInstance().start(sessionContext);

        return null;
    }

    /**
     * 标记当前会话需要持久化
     *
     * @param req
     * @return
     */
    @Override
    public BaseResp annotateSessionDurable(BaseReq req) {
        return null;
    }

    /**
     * 结束当前会话：如用户主动登出时。
     *
     * @param req
     * @return
     */
    @Override
    public BaseResp stopSession(BaseReq req) {
        return null;
    }

    /**
     * 根据会话标识获取指定的会话。
     * longReq，会话标识
     * longReq2,0表示仅限当前有效的会话，1表示以失效时需要从会话持久化库中获取
     *
     * @param req
     * @return 结果存放在objResult中
     */
    @Override
    public BaseResp getBySessionId(BaseReq req) {
        return null;
    }

    /**
     * 根据会话标识获取指定的会话。
     * stringReq，表示待查找的会话令牌
     * longReq2,0表示仅限当前有效的会话，1表示以失效时需要从会话持久化库中获取
     *
     * @param req
     * @return 结果存放在objResult中
     */
    @Override
    public BaseResp getBySessionToken(BaseReq req) {
        return null;
    }
}