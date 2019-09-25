package edu.niit.android.wechat.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.niit.android.wechat.R;
import edu.niit.android.wechat.model.ThreeService;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<ThreeService> services;

    public GridViewAdapter(Context context, List<ThreeService> services) {
        this.context = context;
        this.services = services;
    }

    @Override
    public int getCount() {
        return this.services.size();
    }

    @Override
    public Object getItem(int position) {
        return this.services.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_view, parent, false);
            holder = new ViewHolder();
            holder.imgItem = convertView.findViewById(R.id.img_item);
            holder.tvItem = convertView.findViewById(R.id.tv_item);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ThreeService service = services.get(position);
        holder.imgItem.setImageResource(service.getImgId());
        holder.tvItem.setText(service.getName());
        return convertView;
    }

    static class ViewHolder {
        ImageView imgItem;
        TextView tvItem;
    }
}
