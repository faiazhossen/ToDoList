package com.example.faiaz.todolist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.faiaz.todolist.R;
import com.example.faiaz.todolist.model.Items;

import java.util.ArrayList;

/**
 * Created by FAIAZ on 9/25/2017.
 */

public class CustomListAdapter extends BaseAdapter{
    private Context mContext;
    private ArrayList<Items> items;
    public CustomListAdapter(Context context, ArrayList<Items> itemList){
        mContext = context;
        items = itemList;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_list_item, null);
        }
       TextView name = (TextView) view.findViewById(R.id.name);
        TextView time = (TextView) view.findViewById(R.id.time);
        name.setText(items.get(i).getTaskName());
        time.setText(items.get(i).getTime());
        return  view;
    }
}
