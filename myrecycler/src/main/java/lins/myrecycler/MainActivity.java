package lins.myrecycler;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recycler;
    private ExpandableListView expandableListView;
    private List<String> mDatas;
    private MySimpleAdapter mAdapter;
    private MyExpandableListAdapter myExpandableListAdapter;
    private Button btn1,btn2,btn3,btn4,btn5,btn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = (RecyclerView) findViewById(R.id.id_recycler);
        expandableListView = (ExpandableListView) findViewById(R.id.elist);

        init();
        initDatas();
        mAdapter = new MySimpleAdapter(this,mDatas);
        recycler.setAdapter(mAdapter);

        myExpandableListAdapter = new MyExpandableListAdapter(MainActivity.this);
        expandableListView.setAdapter(myExpandableListAdapter);

        //设置RecyclerView的布局管理
        LinearLayoutManager lins = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(lins);
        recycler.setItemAnimator(new DefaultItemAnimator());

        //recycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        mAdapter.setOnItemClickListener(new MySimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,position+"click",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this,position+"longclick",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        for (int i =0;i<20;i++){
            mDatas.add("hello....");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                //listView普通形式
                recycler.setLayoutManager(new LinearLayoutManager(this));

                break;
            case R.id.button2:
                //GridView形式
                recycler.setLayoutManager(new GridLayoutManager(this,3));

                break;
            case R.id.button3:
                //横向GridView
                recycler.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));

                break;
            case R.id.button4:
                //瀑布流
                startActivity(new Intent(MainActivity.this,MyPuBuActivity.class));
                break;
            case R.id.button5:
                mAdapter.addData(1);
                break;
            case R.id.button6:
                mAdapter.delData(0);
                mAdapter.addData(1);
                break;
        }
    }
    private void init(){
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn6 = (Button) findViewById(R.id.button6);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }
}
