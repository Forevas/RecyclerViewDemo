package com.xiangchao.demo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xiangchao.demo.R;
import com.xiangchao.demo.adapter.MyAdapter;
import com.xiangchao.demo.bean.Data;
import com.xiangchao.demo.bean.ImgInfo;
import com.xiangchao.demo.constants.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    MyAdapter adapter;
    List<Data> datas=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<50;i++){
            Data data=new Data();
            data.prise=0;
            data.imgList=new ArrayList<>();
            int count=1+new Random().nextInt(9);
            for(int j=0;j<count;j++){
                ImgInfo info=new ImgInfo();
                info.url=Constants.urls[new Random().nextInt(Constants.urls.length)];
                data.imgList.add(info);
            }
            datas.add(data);
        }
        recyclerView= (RecyclerView) findViewById(R.id.recycler);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MyAdapter(this,datas);
        recyclerView.setAdapter(adapter);
    }
}
