package com.example.shixun.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    private CompositeDisposable compositeDisposable;
    public void addDisposable(Disposable disposable){
        if(compositeDisposable==null){
            synchronized (this){
                if(compositeDisposable==null){
                    compositeDisposable=new CompositeDisposable();
                }
            }
        }
        compositeDisposable.add(disposable);
    }
    public void dispose(){
        if(compositeDisposable!=null){
            compositeDisposable.dispose();
        }
    }
    public void removeDispose(Disposable disposable){
        if(compositeDisposable!=null){
            compositeDisposable.remove(disposable);
        }
    }
}
