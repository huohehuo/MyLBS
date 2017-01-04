package lins.mylbs;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LINS on 2016/12/12.
 * Please Try Hard
 */
public class JsonUtil {
    public static BusData parsonJson(String string,int how)
    {
        BusData bus =new BusData();
        //用于保存站点名称
        List<String> xianlu = new ArrayList<String>();
        try {
            JSONObject jsonObject = new JSONObject(string);
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            for(int i = 0;i <jsonArray.length();i++)
            {
                if (i==how){
                    JSONObject jsonObject3 = jsonArray.getJSONObject(i);
                    String start_name = jsonObject3.getString("terminal_name");
                    String key_name = jsonObject3.getString("key_name");
                    String end_name = jsonObject3.getString("front_name");
                    String start_time = changeTime(jsonObject3.getString("start_time"));
                    String end_time = changeTime(jsonObject3.getString("end_time"));
                    String road_long=jsonObject3.getString("length");
                    JSONArray jsonArray1 = jsonObject3.getJSONArray("stationdes");
                    for (int j = 0; j < jsonArray1.length(); j++) {
                        JSONObject json = jsonArray1.getJSONObject(j);
                        String name = json.getString("name");
                        Log.d("获得公车站：",name);
                        xianlu.add(name);
                    }
                    bus = new BusData(start_name,end_name,key_name,start_time,end_time,road_long,xianlu);
                }else if(i==how){
                    JSONObject jsonObject3 = jsonArray.getJSONObject(i);
                    String start_name = jsonObject3.getString("terminal_name");
                    String key_name = jsonObject3.getString("key_name");
                    String end_name = jsonObject3.getString("front_name");
                    String start_time = changeTime(jsonObject3.getString("start_time"));
                    String end_time = changeTime(jsonObject3.getString("end_time"));
                    String road_long=jsonObject3.getString("length");
                    JSONArray jsonArray1 = jsonObject3.getJSONArray("stationdes");
                    for (int j = 0; j < jsonArray1.length(); j++) {
                        JSONObject json = jsonArray1.getJSONObject(j);
                        String name = json.getString("name");
                        Log.d("获得公车站：",name);
                        xianlu.add(name);
                    }
                    bus = new BusData(start_name,end_name,key_name,start_time,end_time,road_long,xianlu);
                }
            }
            Log.d("获得线路总数据：",bus.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bus;
    }
    //由于时间是四个连续数字，所以要在他们中间加个冒号
    private static String changeTime(String str){
        StringBuffer sb = new StringBuffer(str);
        return sb.insert(2,":").toString();
    }

    public static BusData getData(String json){
        Gson gson = new Gson();
        BusData busData = gson.fromJson(json,new TypeToken<BusData>(){}.getType());
        return busData;
    }
}
