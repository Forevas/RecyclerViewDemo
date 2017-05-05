package com.xiangchao.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xiangchao.demo.R;
import com.xiangchao.demo.bean.Data;

import java.util.List;

/**
 * Created by Administrator on 2017/5/5 0005.
 */

public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    List<Data> datas;
    LayoutInflater inflater;
    public MyAdapter(Context context, List<Data> datas) {
        this.context=context;
        this.datas=datas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.recycler_item_layout, parent, false);
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder viewHolder= (MyViewHolder) holder;
        Data data = datas.get(position);
        viewHolder.tv.setText("点赞"+data.prise+"次");
        Glide.with(context).load(data.imgList.get(0)).crossFade().placeholder(R.mipmap.def_img_1_1).into(viewHolder.iv);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.img);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
