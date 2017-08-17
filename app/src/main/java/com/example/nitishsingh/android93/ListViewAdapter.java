package com.example.nitishsingh.android93;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Nitish Singh on 29-07-2017.
 */

public class ListViewAdapter extends BaseAdapter {
    //declaration
    Activity context;
    String title[];
    String description[];
    //creating Constructor
    public ListViewAdapter(Activity context, String title[], String description[]) {
        super();
        this.context = context;
        this.title = title;
        this.description = description;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    //here we are creating viewhOLDER CLASS
    private class ViewHolder {
        //Declaration of set of views
        TextView txtViewTitle;
        TextView txtViewDescription;
    }

    //Method getView()
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = context.getLayoutInflater();//retreving layout of current context
        //Here we are applying condition 
        if (view == null) {

            view = inflater.inflate(R.layout.row_main,null);
            holder = new ViewHolder();
            holder.txtViewTitle = (TextView) view.findViewById(R.id.textView);
            holder.txtViewDescription = (TextView) view.findViewById(R.id.textView2);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }
        holder.txtViewTitle.setText(title[position]);//setting title
        holder.txtViewDescription.setText(description[position]);//setting Desciption

        return view;//return view

    }
}

