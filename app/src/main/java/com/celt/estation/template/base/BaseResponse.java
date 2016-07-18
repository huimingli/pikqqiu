package com.celt.estation.template.base;

import java.io.Serializable;

/**
 * Response基类
 * Created by 00013518 on 2016/5/10.
 */
public class BaseResponse implements Serializable {
    int code;
    String msg;
    int ts;
    int point;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
