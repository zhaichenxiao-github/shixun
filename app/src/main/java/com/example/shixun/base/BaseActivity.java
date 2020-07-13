package com.example.shixun.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shixun.R;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter>extends AppCompatActivity implements BaseView {
    public P mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayout());
        ButterKnife.bind(this);
        initPresenter();
        if(mPresenter!=null){
            mPresenter.bindView(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPresenter();

    protected abstract int getlayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
        mPresenter=null;
    }
}
