package com.billing.internalcontract.other;

import com.billing.internalcontract.BaseResp;

/**
 * 序号服务，设计思路：
 * 在billing_product库中建立表sequence_value_item，存储各个序号的当前值，
 * 服务者初始化缓存，
 * 使用者通过缓存来取得下一个序号。
 * 服务者负责在适当的时机保存各序号的当前值。
 * 在系统异常崩溃时，允许各个序号跳过一定量的的序号，以避免冲突。
 * Created by xiaoyouyi on 2014-8-27.
 */
public interface ISeqFacade {
    /**
     * 根据序号名称，取得下一个序号
     * @param seqName
     * @return
     */
    BaseResp nextSeq(String seqName);

    /**
     * 根据序号名称，初始化序号当前值
     * @param seqName
     * @param maxSeq
     * @return
     */
    BaseResp initSeq(String seqName,long maxSeq);
}
