package com.example.a10483.weilog;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 10483 on 2018/1/21.
 */

public class recyclerviewdecoration extends RecyclerView.ItemDecoration {
    private static final int[] attrs=new int[]{android.R.attr.listDivider};
    private Drawable divider;
    private int orientation;

    public recyclerviewdecoration(Context context,int orientation){
        TypedArray typedArray=context.obtainStyledAttributes(attrs);
        divider=typedArray.getDrawable(0);
        typedArray.recycle();
        this.orientation=orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

        drawHDecoration(c,parent);
        drawVDecoration(c,parent);
    }

    private void drawHDecoration(Canvas c,RecyclerView parent){
        int left=parent.getPaddingLeft();
        int right=parent.getWidth()-parent.getPaddingRight();
        int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams=(RecyclerView.LayoutParams)child.getLayoutParams();
            int top=child.getBottom()+layoutParams.bottomMargin;
            int bottom=top+divider.getIntrinsicHeight();
            divider.setBounds(left,top,right,bottom);
            divider.draw(c);
        }
    }

    private void drawVDecoration(Canvas c,RecyclerView parent){
        int top=parent.getPaddingTop();
        int bottom=parent.getHeight()-parent.getPaddingBottom();
        int childCount=parent.getChildCount();
        for(int i=0;i<childCount;i++){
            View child=parent.getChildAt(i);
            RecyclerView.LayoutParams layoutParams=(RecyclerView.LayoutParams)child.getLayoutParams();
            int left=child.getRight()+layoutParams.rightMargin;
            int right=left+divider.getIntrinsicWidth();
            divider.setBounds(left,top,right,bottom);
            divider.draw(c);
        }
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if(OrientationHelper.HORIZONTAL==orientation){
            outRect.set(0,0,divider.getIntrinsicWidth(),0);
        }else{
            outRect.set(0,0,divider.getIntrinsicHeight(),0);

        }

    }
}
