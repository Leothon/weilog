package com.example.a10483.weilog.utils;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by 10483 on 2018/1/20.
 */

public abstract class EndScorllListener  extends RecyclerView.OnScrollListener{
    private LinearLayoutManager linearLayoutManager;
    private int totalItemcount;//已经加载出来的item数量
    private int previousTotal=0;//储存上一个totalItemCount
    private int visibleItemCount;//屏幕可见item数量
    private int firstVisibleItem;//屏幕上可见的item数量
    private boolean loading=true;//判断是否上拉
    private int currentPage=0;

    public EndScorllListener(LinearLayoutManager linearLayoutManager){
        this.linearLayoutManager=linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        visibleItemCount=recyclerView.getChildCount();
        totalItemcount=linearLayoutManager.getItemCount();
        firstVisibleItem=linearLayoutManager.findFirstVisibleItemPosition();
        if(loading){
            if(totalItemcount>previousTotal){
                loading=false;
                previousTotal=totalItemcount;
            }
        }
        if(!loading&&totalItemcount-visibleItemCount<=firstVisibleItem){
            currentPage++;
            onLoadMoredata(currentPage);
            loading=true;
        }
    }

    public abstract void onLoadMoredata(int currentPage);
}
