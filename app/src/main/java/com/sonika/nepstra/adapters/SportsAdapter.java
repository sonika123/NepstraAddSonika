package com.sonika.nepstra.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sonika.nepstra.R;
import com.sonika.nepstra.helpers.JwelleryHelper;
import com.sonika.nepstra.helpers.SportsHelper;
import com.sonika.nepstra.pojo.Jwellery_pojo;
import com.sonika.nepstra.pojo.Sports_pojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 10/18/2017.
 */

public class SportsAdapter extends BaseAdapter{
    Context context;
    List<Sports_pojo> sports_pojoList = new ArrayList<Sports_pojo>();
    int resource;
    SportsHelper dbHelper;

    public SportsAdapter(Context context, List<Sports_pojo> sports_pojoList, int resource) {
        this.context = context;
        this.sports_pojoList = sports_pojoList;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return sports_pojoList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = null;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resource, viewGroup, false);
            holder = new ViewHolder();

            holder.sportsname = row.findViewById(R.id.sports_product_name);
            holder.sportsprice= row.findViewById(R.id.sports_product_price);
            holder.sportsimg_product = row.findViewById(R.id.sports_product_image);

            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }
        final Sports_pojo sportsinfo =sports_pojoList.get(i);

        dbHelper = new SportsHelper(context);

        //holder.orderid.setText(orderInfo.getOrderid().toString());


        holder.sportsname.setText("Name:"+" "+sportsinfo.getSportsname());
        holder.sportsprice.setText("Price:" + " "+sportsinfo.getSportsprice());
        Picasso.with(context).load(sportsinfo.getSportsimage()).into(holder.sportsimg_product);


        return row;
    }

    static class ViewHolder {
        TextView sportsname,sportsprice, sid, scid;

        ImageView sportsimg_product;
    }
}

