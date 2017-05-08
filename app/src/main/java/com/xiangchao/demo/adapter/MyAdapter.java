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
import com.xiangchao.demo.bean.ImgInfo;
import com.xiangchao.demo.util.ScreenUtil;
import com.xiangchao.demo.view.NineGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/5 0005.
 */

public class MyAdapter extends RecyclerView.Adapter {
    Context context;
    List<Data> datas;
    LayoutInflater inflater;

    public MyAdapter(Context context, List<Data> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.recycler_item_layout, parent, false);
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder viewHolder = (MyViewHolder) holder;
        final Data data = datas.get(position);
        viewHolder.tv.setText("点赞" + data.prise + "次");
        viewHolder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.prise++;
                notifyItemChanged(position);
            }
        });
        //设置图片或者视频的尺寸
        viewHolder.gv.setSingleImageSize(ScreenUtil.dip2px(90, context));
        viewHolder.gv.setAdapter(new NineGridViewAdapter(context, data.imgList) {
            @Override
            public void onDisplayImage(Context context, ImageView imageView, String imageInfo) {
//                if (!viewHolder.gv.isVedio()) {
//                    if (imageInfo.endsWith(".gif") || imageInfo.endsWith(".GIF")) {
//                        ImageLoader.displayGifAsBitmap(imageView, imageInfo, DisplayConfig.get1To1DefImgOptions());
//                    } else {
//                        ImageLoader.display(imageView,imageInfo,DisplayConfig.get1To1DefImgOptions());
//                    }
//                } else {
//                    ImageLoader.display(imageView, imageInfo, DisplayConfig.getDefVideoCoverOptions());
//                }
                Glide.with(context).load(imageInfo).crossFade().centerCrop().placeholder(R.mipmap.def_img_1_1).into(imageView);
            }

            @Override
            public void onImageItemOnClick(Context context, int index, List<ImgInfo> imageInfo) {
                super.onImageItemOnClick(context, index, imageInfo);
                //跳转到详情
//                if (null != listener) {
//                    listener.onImageClick(topicData, index);
//                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView iv;
        TextView tv;
        NineGridView gv;

        public MyViewHolder(View itemView) {
            super(itemView);
//            iv = (ImageView) itemView.findViewById(R.id.img);
            tv = (TextView) itemView.findViewById(R.id.tv);
            gv = (NineGridView) itemView.findViewById(R.id.topic_item_nine_grid);
        }
    }
}
