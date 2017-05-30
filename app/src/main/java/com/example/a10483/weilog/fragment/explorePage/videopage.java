package com.example.a10483.weilog.fragment.explorePage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.a10483.weilog.Data.Videodata;
import com.example.a10483.weilog.R;

import java.util.List;
import java.util.zip.Inflater;


public class videopage extends Fragment {

    private List<Videodata> videodata;
    public videopage() {}
    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.videopager,container,false);
        ListView video_listview=(ListView)view.findViewById(R.id.video_listview);
        VideoAdapter adapter=new VideoAdapter(getActivity(),videodata);
        video_listview.setAdapter(adapter);

        return view;
    }

    public final class VideoHolder {
        private VideoView video_in_videopage;
        private ImageView user_icon_in_videopage;
        private TextView user_name_in_videopage;
        private TextView likeother;
        private TextView talkother;
        private TextView context_in_videopage;
    }
    class VideoAdapter extends BaseAdapter{
        private LayoutInflater inflater;
        private List<Videodata> videodatas;
        public  VideoAdapter(Context context, List<Videodata> videodata){
            inflater= LayoutInflater.from(context);
            videodatas=videodata;
        }

        @Override
        public View getView(int position, View conterView, ViewGroup viewGroup) {

            VideoHolder holder=null;
            if (conterView==null){
                holder=new VideoHolder();
                conterView=inflater.inflate(R.layout.video_item,null);
                holder.video_in_videopage=(VideoView)conterView.findViewById(R.id.video_in_videopage);
                holder.context_in_videopage=(TextView)conterView.findViewById(R.id.context_in_videopage);
                holder.user_icon_in_videopage=(ImageView)conterView.findViewById(R.id.user_icon_in_videopage);
                holder.user_name_in_videopage=(TextView)conterView.findViewById(R.id.user_name_in_videopage);
                holder.likeother=(TextView)conterView.findViewById(R.id.likeother);
                holder.talkother=(TextView)conterView.findViewById(R.id.talkother);
                conterView.setTag(holder);
            }else{
                holder=(VideoHolder)conterView.getTag();
            }
            return conterView;
        }
        @Override
        public Object getItem(int i) {
            return null;
        }



        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }
    }

}
