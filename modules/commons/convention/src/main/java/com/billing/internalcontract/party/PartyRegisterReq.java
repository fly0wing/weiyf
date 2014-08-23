package com.billing.internalcontract.party;

import com.billing.internalcontract.BaseReq;
import com.billing.internalcontract.contacttech.ContactMech;
import com.billing.internalcontract.contacttech.FinanceContactMech;

import java.util.List;


/**
 * 商户注册请求
 *
 * @author Youyi Xiao
 *
 */
public class PartyRegisterReq extends BaseReq {
    private PartyRoleEnum partyType;
    private PartyUnitEnum partyUnit;
    private String partyName;
    private String websiteUrl;

    private FinanceContactMech financeContactMech;

    private ContactMech businessContact;
    private ContactMech cutomerServiceContact;
    private ContactMech settlementContact;

    private List<PartyContent> partyContents;

    private String note;
}
