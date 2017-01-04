package lins.myrecycler;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by LINS on 2016/12/16.
 * Please Try Hard
 */
public class MyExpandableListAdapter implements ExpandableListAdapter{

    private Context context;
    private LayoutInflater inflater;
    int[] logos = new int[]{
            R.drawable.res4,
            R.drawable.res5,
            R.drawable.res6,
            R.drawable.res8,
            R.drawable.res9,
            R.drawable.res10
    };
    private String[] armTypes = new String[]{
            "WORD","EXCEL","EMAIL","AAA","BBB","SSS"
    };
    private String[][] arms = new String[][]{
            {"辣子鸡","辣子鸡","辣子鸡","辣子鸡"},
            {"辣子鸡","辣子鸡","辣子鸡","辣子鸡"},
            {"辣子鸡","辣子鸡","辣子鸡","辣子鸡"},
            {"辣子鸡","辣子鸡","辣子鸡","辣子鸡"},
            {"辣子鸡","辣子鸡","辣子鸡","辣子鸡"},
            {"辣子鸡","辣子鸡","辣子鸡","辣子鸡"},

    };
    public MyExpandableListAdapter(Context context){
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return armTypes.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return arms[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return armTypes[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return arms[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//        LinearLayout ll = new LinearLayout(context);
//        ll.setOrientation(LinearLayout.HORIZONTAL);
//        ImageView logo = new ImageView(context);
//        logo.setImageResource(logos[groupPosition]);
//        logo.setPadding(36, 15, 0, 0);
//        ll.addView(logo);
//        TextView textView = getTextView();
//        textView.setText(getGroup(groupPosition).toString());
//        textView.setPadding(10, 0, 0, 0);
//        ll.addView(textView);

        convertView = inflater.inflate(R.layout.exlist_all_item,null);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_one_icon);
        TextView tv_one = (TextView) convertView.findViewById(R.id.tv_one);
        imageView.setImageResource(logos[groupPosition]);
        tv_one.setText(getGroup(groupPosition).toString());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView textView = getTextView();
        textView.setText(getChild(groupPosition, childPosition).toString());
        return textView;
//        convertView = inflater.inflate(R.layout.exlist_sec_item,null);
//        TextView textView1 = (TextView) convertView.findViewById(R.id.tv_rec);
        ////textView1.setText(getChild(groupPosition, childPosition).toString());
       //// textView1.setText(arms[groupPosition][childPosition]);
       // return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }
    private TextView getTextView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 64);
        TextView textView = new TextView(context);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
        textView.setPadding(36, 0, 0, 0);
        textView.setTextSize(20);
        return textView;
    }
}
