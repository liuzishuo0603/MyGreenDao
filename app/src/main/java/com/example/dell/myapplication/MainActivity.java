package com.example.dell.myapplication;
//刘子硕 /2019/5/29/19:47

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.xts.greendaodemo.db.DaoSession;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRlv;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAdd();
        initView();
        initData();
    }

    private void initData() {
        DaoSession daoSession = MyApp.getmDaoSession();
        List<RootBean> list = daoSession.loadAll(RootBean.class);
        mAdapter.mList.addAll(list);
        mAdapter.notifyDataSetChanged();
    }

    private void initAdd() {
        DaoSession daoSession = MyApp.getmDaoSession();
        for (int i = 0; i < 20; i++) {
            RootBean rootBean = new RootBean();
            rootBean.setData("我是第" + i + "条数据");
            daoSession.insert(rootBean);
        }
        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mRlv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mAdapter = new MyAdapter(this);
        mRlv.setAdapter(mAdapter);
    }
}
