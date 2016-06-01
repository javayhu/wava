package com.github.hujiaweibujidao.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.github.hujiaweibujidao.wava.Techniques;

public class EffectAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;

    public EffectAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Techniques.values().length;
    }

    @Override
    public Object getItem(int position) {
        return Techniques.values()[position].getAnimator();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = mLayoutInflater.inflate(R.layout.item, null, false);
        TextView t = (TextView) v.findViewById(R.id.list_item_text);
        Object o = getItem(position);
        int start = o.getClass().getName().lastIndexOf(".") + 1;
        String name = o.getClass().getName().substring(start);
        t.setText(name);
        v.setTag(Techniques.values()[position]);
        return v;
    }
}
