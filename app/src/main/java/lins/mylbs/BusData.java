package lins.mylbs;

import java.util.List;

/**公车信息实体类
 * Created by LINS on 2016/12/12.
 * Please Try Hard
 */
public class BusData {
    private String start_name;//开始站名
    private String end_name;//结束站名
    private String key_name;//线路名
    private String start_time;//开始时间
    private String end_time;//结束时间
    private String road_long;//线路长度
    private List<String> xianlu;//线路站名
    public BusData(){}

    public BusData(String start_name, String end_name, String key_name, String start_time,
                   String end_time, String road_long, List<String> xianlu) {
        this.start_name = start_name;
        this.end_name = end_name;
        this.key_name = key_name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.road_long = road_long;
        this.xianlu = xianlu;
    }

    public String getStart_name() {
        return start_name;
    }

    public void setStart_name(String start_name) {
        this.start_name = start_name;
    }

    public String getEnd_name() {
        return end_name;
    }

    public void setEnd_name(String end_name) {
        this.end_name = end_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getKey_name() {
        return key_name;
    }

    public void setKey_name(String key_name) {
        this.key_name = key_name;
    }

    public String getRoad_long() {
        return road_long;
    }

    public void setRoad_long(String road_long) {
        this.road_long = road_long;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public List<String> getXianlu() {
        return xianlu;
    }

    public void setXianlu(List<String> xianlu) {
        this.xianlu = xianlu;
    }

    @Override
    public String toString() {
        return "BusData{" +
                "start_name='" + start_name + '\'' +
                ", end_name='" + end_name + '\'' +
                ", key_name='" + key_name + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                ", road_long='" + road_long + '\'' +
                ", xianlu=" + xianlu +
                '}';
    }
}
