package com.celt.estation.template.base;

import com.google.gson.annotations.SerializedName;

/**
 * 获取验证码请求
 *
 * @author liugz
 *         Created on 16/6/7.
 */
public class GetFreeListRequest extends BaseRequest {

    public GetFreeListRequest(String page,String offset) {
        super();
        this.param = new GetCaptchaParameter(page,offset);
        this.sign = getSign();
    }

    class GetCaptchaParameter {
        @SerializedName("page")
        String page;
        @SerializedName("offset")
        String offset;

        public GetCaptchaParameter(String page,String offset) {
            this.page = page;
            this.offset = offset;
        }

        public String getOffset() {
            return offset;
        }

        public void setOffset(String offset) {
            this.offset = offset;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }
    }
}
