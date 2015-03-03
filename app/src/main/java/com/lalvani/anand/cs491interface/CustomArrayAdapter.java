package com.lalvani.anand.cs491interface;

/**
 * Created by Anand on 3/2/2015.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomArrayAdapter extends ArrayAdapter {

    Context context;
    int layoutResourceId;
    ListItem[] listItems;


    public CustomArrayAdapter(Context context, int layoutResourceId, ListItem[] items) {
        super(context, layoutResourceId, items);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.listItems = items;
    }

    /*private view holder class*/
    private class ViewHolder {
        ImageView imgView;
        TextView txtName;
        TextView txtTime;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
        {
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtTime = (TextView) convertView.findViewById(R.id.time);
            holder.txtName = (TextView) convertView.findViewById(R.id.name);
            holder.imgView = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        ListItem listItem = (ListItem) getItem(position);

        holder.txtTime.setText(listItem.getTime());
        holder.txtName.setText(listItem.getName());
        holder.imgView.setImageResource(listItem.getImageId());

        return convertView;
    }

    @Override
    public int getCount() {
        return listItems.length;
    }

    @Override
    public Object getItem(int position) {
        return listItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
