package lins.myrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MyPuBuActivity extends AppCompatActivity {
    private RecyclerView recycler;
    private List<String> mDatas;
    private MyPuBuAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_pu_bu);
        recycler = (RecyclerView) findViewById(R.id.id_recy);
        initDatas();
        mAdapter = new MyPuBuAdapter(this,mDatas);
        recycler.setAdapter(mAdapter);

        //设置RecyclerView的布局管理
        StaggeredGridLayoutManager lins = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recycler.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //recycler.addItemDecoration(new DividerGridItemDecoration(this));
    }
    private void initDatas() {
        mDatas = new ArrayList<String>();
        for (int i =0;i<20;i++){
            mDatas.add("hello....");
        }
    }
}
