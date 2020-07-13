package com.example.shixun.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    public V mView;
    private ArrayList<BaseModel> models=new ArrayList<>();
    public BasePresenter(){
        initModel();
    }

    protected abstract void initModel();

    public void addModel(BaseModel baseModel){
        models.add(baseModel);
    }
    public void bindView(V view){
        this.mView=view;
    }
    public void destroy(){
        mView=null;
        for (int i = 0; i < models.size(); i++) {
            models.get(i).dispose();
        }
    }
}
