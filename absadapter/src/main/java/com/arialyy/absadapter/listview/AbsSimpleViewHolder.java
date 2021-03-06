/*
 * Copyright (C) 2016 AriaLyy(AbsAdapter)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.arialyy.absadapter.listview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Adapter通用的holder
 *
 * @author lyy
 */
public class AbsSimpleViewHolder {
    /**
     * 转载一个item里面所有控件的数组
     */
    private SparseArray<View> mViews;
    /**
     * item所加载的view
     */
    private View mConvertView;
    private int mPosition;
    private Context mContext;

    private AbsSimpleViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        mContext = context;
        this.mPosition = position;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public Context getContext() {
        return mContext;
    }

    /**
     * 拿到一个ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    public static AbsSimpleViewHolder getViewHolder(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new AbsSimpleViewHolder(context, parent, layoutId, position);
        }
        return (AbsSimpleViewHolder) convertView.getTag();
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public AbsSimpleViewHolder setText(int viewId, CharSequence text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    public AbsSimpleViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     */
    public AbsSimpleViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 设置RadioButton
     *
     * @param viewId
     * @param checked
     * @return
     */
    public AbsSimpleViewHolder setRadioButton(int viewId, Boolean checked) {
        RadioButton radioBt = getView(viewId);
        radioBt.setChecked(checked);
        return this;
    }

    /**
     * 是否显示radioBt
     *
     * @param viewId
     * @param visible
     * @return
     */
    public AbsSimpleViewHolder setRadioBtVisiable(int viewId, boolean visible) {
        RadioButton radioBt = getView(viewId);
        radioBt.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public int getPosition() {
        return mPosition;
    }
}