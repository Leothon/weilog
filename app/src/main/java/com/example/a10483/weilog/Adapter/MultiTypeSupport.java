package com.example.a10483.weilog.Adapter;

/**
 * Created by 10483 on 2018/1/20.
 */

public interface MultiTypeSupport<T> {
    int getLayoutId(int itemType);
    int getItemViewType(int position,T t);
}
