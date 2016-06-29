package com.arialyy.absadapter.delegate.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.arialyy.absadapter.AbsUtil;
import com.arialyy.absadapter.delegate.AbsDEntity;
import com.arialyy.absadapter.delegate.AbsDManager;
import com.arialyy.absadapter.listview.AbsLvHolder;

import java.util.List;

/**
 * Created by lyy on 2016/3/28.
 * 处理含有多个ViewType的Adapter使用
 */
public abstract class AbsLvDAdapter<T extends AbsDEntity> extends BaseAdapter {
    private   LayoutInflater mInflater;
    protected List<T>        mData;
    private   Context        mContext;
    protected AbsDManager mManager = new AbsDManager();
    private String TAG;

    public AbsLvDAdapter(Context context, List<T> data) {
        mInflater = LayoutInflater.from(context);
        mData = data;
        mContext = context;
        TAG = AbsUtil.getClassName(this);
    }

    public List<T> getData() {
        return mData;
    }

    protected Context getContext() {
        return mContext;
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getAbsType();
    }

    @Override
    public int getViewTypeCount() {
        return mManager.getMaxType() + 1;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AbsLvHolder      holder;
        int              type       = getItemViewType(position);
        AbsILvDelegation delegation = (AbsILvDelegation) mManager.getDelegate(type);
        if (delegation == null) {
            throw new NullPointerException("没有type == " + type + "的Delegate");
        }
        if (convertView == null) {
            convertView = mInflater.inflate(delegation.setLayoutId(), null);
            holder = delegation.createHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (AbsLvHolder) convertView.getTag();
        }
        delegation.bindData(position, holder, mData.get(position));
        return convertView;
    }
}
