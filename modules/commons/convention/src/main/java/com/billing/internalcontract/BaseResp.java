package com.billing.internalcontract;

import java.io.Serializable;
import java.util.Date;

/**
 * 方法调用返回结果的一般定义
 * @author Youyi Xiao
 *
 */
public class BaseResp<T> implements Serializable {
    public final static int SUCCESS=0;
    /**
     * 请求的唯一标识
     */
    private String requestGuid;
    /**

     * 应答时间
     */
    private Date respTime;
    /**
     * 当前的会话
     */
    private UserSession session;
	private boolean isNormal;
	private long code;
	private String desc;
	private Exception exception;
	private long longResult;
	private String stringResult;
	private long longResult2;
    private String stringResult2;
    private long longResult3;
    private String stringResult3;
    /**
     * 结果集
     */
    private T objResult;

    public BaseResp(){

    }
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

    public Date getRespTime() {
        return respTime;
    }

    public void setRespTime(Date respTime) {
        this.respTime = respTime;
    }

    public String getRequestGuid() {
        return requestGuid;
    }

    public void setRequestGuid(String requestGuid) {
        this.requestGuid = requestGuid;
    }

    public UserSession getSession() {
        return session;
    }

    public void setSession(UserSession session) {
        this.session = session;
    }

    public String getDesc() {
        return desc;
    }

	public void setDesc(String desc) {
		this.desc = desc;
	}

    public long getLongResult() {
        return longResult;
    }

    public void setLongResult(long longResult) {
        this.longResult = longResult;
    }

    public T getObjResult() {
        return objResult;
    }

    public void setObjResult(T objResult) {
        this.objResult = objResult;
    }

    public String getStringResult() {
        return stringResult;
    }

    public void setStringResult(String stringResult) {
        this.stringResult = stringResult;
    }

    public long getLongResult2() {
        return longResult2;
    }

    public void setLongResult2(long longResult2) {
        this.longResult2 = longResult2;
    }

    public String getStringResult2() {
        return stringResult2;
    }

    public void setStringResult2(String stringResult2) {
        this.stringResult2 = stringResult2;
    }

    public long getLongResult3() {
        return longResult3;
    }

    public void setLongResult3(long longResult3) {
        this.longResult3 = longResult3;
    }

    public String getStringResult3() {
        return stringResult3;
    }

    public void setStringResult3(String stringResult3) {
        this.stringResult3 = stringResult3;
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
		return code == SUCCESS;
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

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
