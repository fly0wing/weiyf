package com.billing.internalcontract;

import java.io.Serializable;
import java.util.Date;

/**
 * 方法调用返回结果的一般定义
 * @author Youyi Xiao
 *
 */
public class BaseResp implements Serializable {

	private boolean isNormal;
	private long code;
	private String desc;
	private Exception exception;

	private long longResult;
	private String stringResult;
	private long longResult2;
	private String stringResult2;

	public BaseResp(boolean isNormal, long resultCode, String resultDesc,
                    Exception exception) {
		this.isNormal = isNormal;
		this.code = resultCode;
		this.desc = resultDesc;
		this.exception = exception;
	}

	public BaseResp(boolean isNormal, long resultCode, String resultDesc) {
		this.isNormal = isNormal;
		this.code = resultCode;
		this.desc = resultDesc;
	}

	public BaseResp(boolean isNormal, long resultCode) {
		this.isNormal = isNormal;
		this.code = resultCode;
	}

	public BaseResp(boolean isNormal) {
		this.isNormal = isNormal;
	}

	public static BaseResp ok() {
		return new BaseResp(true);
	}

	public static BaseResp fail(String resultDesc) {
		return new BaseResp(false, 0, resultDesc);
	}

	/**
	 * 
	 * @return true表示无需再次尝试？
	 */
	public boolean isNormal() {
		return isNormal;
	}
	/**
	 * code等于0则返回true
	 * @return:
	 */
	public boolean isOK()	{
		return code==0;
	}

	/**
	 * 
	 * @return 0一般表示成功
	 */
	public long getCode() {
		return code;
	}	

	public void setCode(long code) {
		this.code = code;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void fillCodeAndDesc(long code,String desc){
		this.code=code;
		this.desc= desc;
	}

	public String getResultDesc() {
		return desc;
	}

	public Exception getException() {
		return exception;
	}

}
