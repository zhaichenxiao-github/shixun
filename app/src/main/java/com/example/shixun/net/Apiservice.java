package com.example.shixun.net;

import com.example.shixun.bean.NetBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Apiservice {
    String base_url="http://c.m.163.com/";
    @GET("nc/article/headline/T1348647909107/0-20.html")
    Observable<NetBean> getdata();
}
