package com.example.shixun.net;

import com.example.shixun.bean.NetBean;

public interface MainCallBack {
    void onSuccess(NetBean netBean);
    void onFail(String str);
}
