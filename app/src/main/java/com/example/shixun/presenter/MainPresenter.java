package com.example.shixun.presenter;

import com.example.shixun.base.BasePresenter;
import com.example.shixun.bean.NetBean;
import com.example.shixun.model.MainModel;
import com.example.shixun.net.MainCallBack;
import com.example.shixun.view.MainView;

public class MainPresenter extends BasePresenter<MainView> implements MainCallBack {

    private MainModel mainModel;

    @Override
    protected void initModel() {
        mainModel = new MainModel();
        addModel(mainModel);
    }

    @Override
    public void onSuccess(NetBean netBean) {
        mView.setData(netBean);
    }

    @Override
    public void onFail(String str) {
        mView.showToast(str);
    }

    public void getData() {
        mainModel.getData(this);
    }
}
