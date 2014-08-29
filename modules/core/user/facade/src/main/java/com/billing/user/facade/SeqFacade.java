package com.billing.user.facade;

import com.billing.internalcontract.BaseResp;
import com.billing.internalcontract.other.ISeqFacade;
import com.billing.user.orm.dao.SequenceValueItemDao;
import com.billing.user.orm.model.SequenceValueItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by xiaoyouyi on 2014-8-27.
 */
@Service
public class SeqFacade implements ISeqFacade {
    private static Object monitor = new Object();

    public static final String  USER_SESSION_ID="user_session_id";

    @Autowired
    private SequenceValueItemDao sequenceValueItemDao;

    //@Be
    public void init( ){

    }

    @Override
    public BaseResp nextSeq(String seqName) {
        BaseResp resp;
        long nextSeq;
        synchronized (monitor ) {
            SequenceValueItem sequenceValueItem=getSequenceByName(seqName);
            if ( sequenceValueItem==null ) return  new BaseResp(true,1,"不存在的序号名称",null);

            nextSeq = sequenceValueItem.getSeqId() + 1;
            sequenceValueItem.setSeqId(nextSeq);
            sequenceValueItemDao.update(sequenceValueItem);
        }
        resp=new BaseResp(true,0);
        resp.setLongResult(nextSeq);
        return resp;
    }

    @Override
    public BaseResp initSeq(String seqName, long maxSeq) {
        BaseResp resp;
        synchronized (monitor ) {
            SequenceValueItem sequenceValueItem = getSequenceByName(seqName);
            if (sequenceValueItem == null) return new BaseResp(true, 1, "", null);

            long nextSeq = sequenceValueItem.getSeqId();
            if (nextSeq < maxSeq) {
                sequenceValueItem.setSeqId(maxSeq);
                sequenceValueItemDao.update(sequenceValueItem);
            }
        }
        resp=new BaseResp(true,0);

        return resp;
    }

    public SequenceValueItem getSequenceByName(String seqName){
        return  sequenceValueItemDao.get(seqName);
    }
}
