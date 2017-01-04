package lins.mylbs;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BusActivity extends AppCompatActivity {

    private TextView title,start,end,start_time,end_time,road_long;
    private ListView mListView;
    private ImageView iv_back;
    private ProgressBar pb;
    private Button btn;
    private MyAdatper adatper;
    private BusData bus;
    private String txt_city,txt_line;
    private boolean isChange=true;
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {

                BusData data = (BusData) msg.obj;
                setTextData();
                List<String> sss = data.getXianlu();
            adatper = new MyAdatper(BusActivity.this,sss);
            mListView.setAdapter(adatper);
            mListView.setVisibility(View.VISIBLE);
            pb.setVisibility(View.GONE);
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);
        bindViews();

        Intent intent = getIntent();
        txt_city = intent.getStringExtra("city");
        txt_line = intent.getStringExtra("line");

        mListView.setVisibility(View.INVISIBLE);
        pb.setVisibility(View.VISIBLE);
        getData(0);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChange){
                    mListView.setVisibility(View.INVISIBLE);
                    pb.setVisibility(View.VISIBLE);
                    //执行回路线的数据解析
                    getData(1);
                    isChange = false;
                }else{
                    mListView.setVisibility(View.INVISIBLE);
                    pb.setVisibility(View.VISIBLE);
                    //执行去的路线的数据解析
                    getData(0);
                    isChange =true;
                }
                Log.d("判断",isChange+"");
            }
        });
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void getData(final int how) {
        RequestQueue queue = Volley.newRequestQueue(BusActivity.this);
        String url = "http://op.juhe.cn/189/bus/busline";
        //?dtype=json&city=北京&bus=478&key=6f0e2a5d983cd6045f11eb0086eb5b3c
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // 将会获取到返回的数据
                        Log.d("控制台打印出json数据：", response);
                        bus =JsonUtil.parsonJson(response,how);
                        Message message = Message.obtain();
                        message.obj= bus;
                        handler.sendMessage(message);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("check>>>>>>", "网络错误。。。。");
                Toast.makeText(BusActivity.this, "网络错误，请重试", Toast.LENGTH_SHORT).show();
            }
        }) {
            // 重写该方法，构造出请求信息
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<String, String>();
                map.put("dtype", "json");
                map.put("city", txt_city);
                map.put("bus", txt_line);
                map.put("key", "6f0e2a5d983cd6045f11eb0086eb5b3c");
                return map;
            }
        };
        queue.add(stringRequest);
        }
    private void setTextData(){
        title.setText(bus.getKey_name());
        start.setText(bus.getStart_name());
        end.setText(bus.getEnd_name());
        start_time.setText(bus.getStart_time());
        end_time.setText(bus.getEnd_time());
        road_long.setText(bus.getRoad_long()+"公里");
    }
    private void bindViews() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        title = (TextView) findViewById(R.id.tv_bus);
        start = (TextView) findViewById(R.id.tv_s);
        end = (TextView) findViewById(R.id.tv_e);
        start_time = (TextView) findViewById(R.id.tv_time_start);
        end_time = (TextView) findViewById(R.id.tv_time_end);
        road_long = (TextView) findViewById(R.id.tv_long);
        btn = (Button) findViewById(R.id.btn_change);
        mListView = (ListView) findViewById(R.id.listView);
        pb = (ProgressBar) findViewById(R.id.my_pb);
    }


}
