package com.billing.user.facade;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.user.IUserTerminalFacade;
import com.billing.internalcontract.user.TerminalBindReq;
import com.billing.internalcontract.user.TerminalUnbindReq;

/**
 * Created by zkai on 2014/8/26.
 */
public class UserTerminalFacade implements IUserTerminalFacade {
    @Override
    public BaseResp bindTerminal(TerminalBindReq terminalBindReq) {
        return null;
    }

    @Override
    public BaseResp getBoundTerminals(BaseReq baseReq) {
        return null;
    }

    @Override
    public BaseResp unbindTerminal(TerminalUnbindReq terminalUnbindReq) {
        return null;
    }

    @Override
    public BaseResp getTerminalByFingerprint(BaseReq baseReq) {
        return null;
    }
}
