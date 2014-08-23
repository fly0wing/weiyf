package com.billing.internalcontract.content;

import com.billing.internalcontract.BaseResp;

/**
 * 内容管理接口
 * Created by xiaoyouyi on 2014-8-23.
 */
public interface IContentMgrFacade {
    BaseResp uploadContent(UploadContentReq req);
}
