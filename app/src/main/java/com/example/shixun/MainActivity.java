package com.example.shixun;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shixun.base.BaseActivity;
import com.example.shixun.bean.NetBean;
import com.example.shixun.presenter.MainPresenter;
import com.example.shixun.view.MainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.btn_set)
    Button btnSet;
    @BindView(R.id.btn_delete)
    Button btnDelete;
    @BindView(R.id.btn_ok)
    Button btnOk;
    private ArrayList<NetBean.T1348647909107Bean> list;
    private RvAdapter rvAdapter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    protected void initView() {
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, RecyclerView.VERTICAL));
        list = new ArrayList<>();
        rvAdapter = new RvAdapter(this, list);
        rv.setAdapter(rvAdapter);
    }

    @Override
    protected void initPresenter() {
        mPresenter=new MainPresenter();
    }

    @Override
    protected int getlayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(NetBean netBean) {
        List<NetBean.T1348647909107Bean> t1348647909107 = netBean.getT1348647909107();
        list.addAll(t1348647909107);
        rvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_set, R.id.btn_delete, R.id.btn_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_set:
                setEdit();
                break;
            case R.id.btn_delete:
                setDelete();
                break;
            case R.id.btn_ok:
                setOk();
                break;
        }
    }
    private void setOk() {
        for (int i = 0; i < list.size(); i++) {
            NetBean.T1348647909107Bean t1348647909107Bean = list.get(i);
            t1348647909107Bean.setHasIcon(false);
        }
        rvAdapter.isShow=false;
        rvAdapter.notifyDataSetChanged();
    }

    private void setDelete() {
        ArrayList<NetBean.T1348647909107Bean> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            NetBean.T1348647909107Bean t1348647909107Bean = list.get(i);
            if(t1348647909107Bean.isHasIcon()==false){//不删除的数据，收集到新集合中
                list1.add(t1348647909107Bean);
            }
        }
        list.clear();
        list.addAll(list1);
        rvAdapter.notifyDataSetChanged();
    }

    //点击操作显示checkbox
    private void setEdit() {
        rvAdapter.isShow=true;
        rvAdapter.notifyDataSetChanged();
    }
}
