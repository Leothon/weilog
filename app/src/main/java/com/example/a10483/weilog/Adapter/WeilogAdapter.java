package com.example.a10483.weilog.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.example.a10483.weilog.utils.ViewHolder;

import java.util.ArrayList;

//通用的Adapter，使用时只需要引用内部类即可调用，参数为上下文，数据List，Item的Id。
public abstract class WeilogAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    protected LayoutInflater inflater;
    protected Context mContext;
    protected ArrayList<T> weilogdatas;
    protected  int mItemLayoutId;
    private int position;
    private MultiTypeSupport multiTypeSupport;
    public AdapterView.OnItemClickListener mItemClickListener;
    public View.OnLongClickListener mLongClickListener;
    public WeilogAdapter(Context context, ArrayList<T> weilogdata ,int ItemLayoutId){
        this.inflater= LayoutInflater.from(context);
        this.mContext=context;
        this.weilogdatas=weilogdata;
        this.mItemLayoutId=ItemLayoutId;

    }
    public WeilogAdapter(Context context,ArrayList<T> weilogdatas,MultiTypeSupport<T> multiTypeSupport) {
        this(context, weilogdatas, -1);
        this.multiTypeSupport = multiTypeSupport;
    }
    @Override
    public int getItemCount() {
        return weilogdatas.size();

    }
    public ArrayList<T> getDatas() {
        return weilogdatas;
    }




    public void setOnItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener longClickListener) {
        this.mLongClickListener = longClickListener;
    }

    /*@Override
    public View getView(int position, View contertView, ViewGroup parent) {

        ViewHolder holder=null;

        if (contertView==null){
            holder=new ViewHolder();
            contertView=inflater.inflate(R.layout.weilogitem,null);
            holder.user_head=(ImageView)contertView.findViewById(R.id.user_head);
            holder.user_name=(TextView)contertView.findViewById(R.id.user_name);
            holder.user_v=(ImageView)contertView.findViewById(R.id.user_v);
            holder.weilog_time=(TextView)contertView.findViewById(R.id.weilog_time);
            holder.weilog_context=(TextView)contertView.findViewById(R.id.weilog_context);
            holder.image_in_context=(ImageView)contertView.findViewById(R.id.image_in_context);
            holder.video_in_context=(VideoView)contertView.findViewById(R.id.video_in_context);
            holder.share_layout=(LinearLayout)contertView.findViewById(R.id.share_layout);
            holder.share_context=(TextView)contertView.findViewById(R.id.share_context);
            holder.image_in_sharecontext=(ImageView)contertView.findViewById(R.id.image_in_sharecontext);
            holder.video_in_sharecontext=(VideoView)contertView.findViewById(R.id.video_in_sharecontext);
            holder.from_deivce=(TextView)contertView.findViewById(R.id.from_device);
            holder.share_button=(TextView)contertView.findViewById(R.id.share_button);
            holder.talk_button=(TextView)contertView.findViewById(R.id.talk_button);
            holder.like_button=(TextView)contertView.findViewById(R.id.like_button);
            contertView.setTag(holder);
        }else{
            holder=(ViewHolder)contertView.getTag();
        }

        return contertView;
    }
    public final class ViewHolder{
        public ImageView user_head;
        public TextView user_name;
        public ImageView user_v;
        public TextView weilog_time;
        public TextView weilog_context;
        public ImageView image_in_context;
        public VideoView video_in_context;
        public LinearLayout share_layout;
        public TextView share_context;
        public ImageView image_in_sharecontext;
        public VideoView video_in_sharecontext;
        public TextView from_deivce;
        public TextView share_button;
        public TextView talk_button;
        public TextView like_button;
    }*/



    @Override
    public int getItemViewType(int position) {
        //if(m{//多布局支持
        //}ultiTypeSupport!=null)
        return multiTypeSupport.getItemViewType(position,weilogdatas.get(position));

    }

   /* @Override
    public T getItem(int position) {
        this.position = position;
        return weilogdatas.get(position);
    }*/
    /*@Override
    public long getItemId(int position) {
        this.position=position;
        return position;
    }*/
    public int getPosition(){
        return position;
    }

    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder=getViewHolder(position,convertView,parent);
        convert(viewHolder,getItem(position));
        return viewHolder.getConvertView();
    }*/

    public abstract void convert(ViewHolder helper,T item);

    /*private ViewHolder getViewHolder(int position,View convertView,ViewGroup parent){
        return ViewHolder.get(mContext,convertView,parent,mItemLayoutId,position);
    }*/

    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {

        mItemLayoutId=multiTypeSupport.getLayoutId(viewType);

        //View itemView = inflater.inflate(mItemLayoutId, parent, false);
        //ViewHolder holder = new ViewHolder(itemView);
        ViewHolder viewholder=ViewHolder.get(mContext,parent,mItemLayoutId,position);

        return viewholder;

    }

    public void onBindViewHolder(ViewHolder holder,final int position) {
        /*if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(position);
                }
            });
        }
        if (mLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return mLongClickListener.onLongClick(position);
                }
            });
        }*/

        this.position=position;
        convert(holder, weilogdatas.get(position));
    }
}
