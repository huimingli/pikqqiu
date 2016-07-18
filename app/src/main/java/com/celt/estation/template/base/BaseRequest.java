package com.celt.estation.template.base;

import android.os.Build;

import com.celt.estation.template.utils.Md5;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;


/**
 * Class:BaseRequest
 * Description:请求基类
 * Author:liugz
 * Date:2016/5/10
 */

public class BaseRequest {
    int appId;//应用id
    String appVersion;//应用版本
    String network;//用户网络环境
    @SerializedName("t")
    int time;//当前时间戳
    String deviceNo;//设备唯一标记号
    String sign;//签名
    String model;//机型
    String systemVer;//操作系统版本
    Object param;//接口参数

    public BaseRequest() {
        this.param = new Object();//避免param为空时不转换该字段的问题
        this.appId = 100;
        this.time = (int) (System.currentTimeMillis() / 1000);
        this.network = "wifi";
        this.appVersion = "wifi";
        this.model = Build.MODEL;
        this.sign = getSign();
        this.deviceNo = "test000";
        this.systemVer = Build.VERSION.SDK_INT + "";

    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSystemVer() {
        return systemVer;
    }

    public void setSystemVer(String systemVer) {
        this.systemVer = systemVer;
    }

    public Object getParam() {
        if (null == param)
            return "";
        return param;
    }

    public void setParam(Object param) {
        this.param = param;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getSign() {
        //TODO 补全key获取
        String key = "5chQN0F4Ya";
        String preSign = key + getAppId() + getAppVersion() + getParamStr() + getTime() + key;
        this.sign = Md5.md5Toword(preSign);

        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getParamStr() {
        if (null == param) {
            return "";
        } else {
            return new GsonBuilder().create().toJson(param);
        }
    }
}
