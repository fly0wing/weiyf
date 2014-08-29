package com.billing.user.facade.shiro;

import com.billing.internalcontract.other.ISeqFacade;
import com.billing.user.facade.SeqFacade;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by xiaoyouyi on 2014-8-28.
 */
@Service
public class WyfSessionIdGenerator implements SessionIdGenerator {

    @Autowired
    ISeqFacade seqFacade;

    public WyfSessionIdGenerator(){

    }
    /**
     * Generates a new ID to be applied to the specified {@code Session} instance.
     *
     * @param session the {@link org.apache.shiro.session.Session} instance to which the ID will be applied.
     * @return the id to assign to the specified {@link org.apache.shiro.session.Session} instance before adding a record to the EIS data store.
     */
    @Override
    public Serializable generateId(Session session) {
        return Long.toString(seqFacade.nextSeq(SeqFacade.USER_SESSION_ID).getLongResult());
    }
}
