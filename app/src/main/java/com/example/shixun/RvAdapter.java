package com.example.shixun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shixun.bean.NetBean;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<NetBean.T1348647909107Bean> list;
    public boolean isShow;


    public RvAdapter(Context context, ArrayList<NetBean.T1348647909107Bean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NetBean.T1348647909107Bean t1348647909107Bean = list.get(position);
        Glide.with(context).load(t1348647909107Bean.getImgsrc()).into(holder.iv);
        holder.tv.setText(t1348647909107Bean.getSource());
        if(isShow==true){//true显示
            holder.ck.setVisibility(View.VISIBLE);
        }else{//False是不显示
            holder.ck.setVisibility(View.INVISIBLE);
        }
        //复选框
        holder.ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true){
                    //选中
                    list.get(position).setHasIcon(true);
                }else{
                    list.get(position).setHasIcon(false);
                }
            }
        });
        holder.ck.setChecked(list.get(position).isHasIcon());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        private CheckBox ck;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            tv=itemView.findViewById(R.id.tv);
            ck=itemView.findViewById(R.id.ck);
        }
    }
}
