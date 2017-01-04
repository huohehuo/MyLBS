package lins.myrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LINS on 2016/12/12.
 * Please Try Hard
 */
public class MySimpleAdapter extends RecyclerView.Adapter<MySimpleAdapter.MyViewHolder>{

    private LayoutInflater inflater;
    private Context context;
    private List<String> mDatas;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }
    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }
    public MySimpleAdapter(Context context, List<String> datas){
        this.context = context;
        this.mDatas = datas;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv.setText(mDatas.get(position));
        if (mOnItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //如果用参数position，会在调用addData添加item数据的时候会出现position值都是一样的情况
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView,layoutPosition);
                }

            });
            //longClick
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView,layoutPosition);
                    return false;
                }
            });
        }

    }
    @Override
    public int getItemCount() {
        return mDatas.size();
    }
    public void addData(int pos){
        mDatas.add(pos,"111111");
        notifyDataSetChanged();
       // notifyItemInserted(pos);
       // notifyItemChanged(pos);注意不是这个方法，不然不会有动画效果
    }
    public void delData(int pos){
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        public MyViewHolder(View v) {
            super(v);
            tv = (TextView) v.findViewById(R.id.tv_rec);
        }
    }
}
