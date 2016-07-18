package com.celt.estation.template.base;

import com.google.gson.annotations.SerializedName;

/**
 * 获取验证码请求
 *
 * @author liugz
 *         Created on 16/6/7.
 */
public class GetCaptchaRequest extends BaseRequest {

    public GetCaptchaRequest(String phoneNo) {
        super();
        this.param = new GetCaptchaParameter(phoneNo);
        this.sign = getSign();
    }

    class GetCaptchaParameter {
        @SerializedName("phone")
        String phoneNo;

        public GetCaptchaParameter(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }
    }
}
