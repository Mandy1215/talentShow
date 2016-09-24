package com.example.mandy.talentshow;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Mandy on 2016/9/11.
 */
public class MyAdapter extends BaseAdapter{
    private Context context;
    private Cursor cursor;
    
    public MyAdapter(Context context , Cursor cursor){
        this.context = context ;
        this.cursor = cursor;
    }
    @Override
    public int getCount() {
        return cursor.getCount();
    }

    @Override
    public Object getItem(int position) {
        return cursor.getPosition();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.bbs_activity , null);



        return null;
    }
}
