package com.example.jiren.demofragment;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.List;

public class ListItemAdapter extends BaseAdapter {
    int mlayout;
    Context mContext;
    List<ItemObject> arrItemObjects;

    public ListItemAdapter(int layout, Context context, List<ItemObject> arrItemObjects) {
        this.mlayout = layout;
        mContext = context;
        this.arrItemObjects = arrItemObjects;
    }

    @Override
    public int getCount() {
        return arrItemObjects.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(mlayout,null);

        TextView textView=convertView.findViewById(R.id.tvItem);
        textView.setText(arrItemObjects.get(position).getString());

        return convertView;
    }
}
