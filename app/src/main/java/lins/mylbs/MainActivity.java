package lins.mylbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//这是分支sub2
//网络  分支
public class MainActivity extends AppCompatActivity {

    private EditText ed1,ed2;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

         btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              //为了检测输入框是否为空
              if (!ed1.getText().toString().equals("")&&!ed2.getText().toString().equals("")){
              //带数据跳转到第二个Activity
              Intent intent= new Intent(MainActivity.this,BusActivity.class);
              intent.putExtra("city",ed1.getText().toString());
              intent.putExtra("line",ed2.getText().toString());
              startActivity(intent);
              }else{
                  Toast.makeText(MainActivity.this, "请输入相应的数据。。。", Toast.LENGTH_SHORT).show();
              }
          }
      });
    }
    private void initView() {
        ed1 = (EditText) findViewById(R.id.et_input_city);
        ed2 = (EditText) findViewById(R.id.et_input_line);
        btn = (Button) findViewById(R.id.button);
    }
}
