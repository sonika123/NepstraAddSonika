package com.sonika.nepstra.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sonika.nepstra.Navigations.Jwellery;
import com.sonika.nepstra.R;
import com.sonika.nepstra.helpers.ArtAndCraftHelper;
import com.sonika.nepstra.helpers.JwelleryHelper;
import com.sonika.nepstra.pojo.ArtAndCraft_pojo;
import com.sonika.nepstra.pojo.Jwellery_pojo;
import com.squareup.picasso.Picasso;

import org.jsoup.Connection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 10/17/2017.
 */

public class JwelleryAdapter extends BaseAdapter{
    Context context;
    List<Jwellery_pojo> jwellery_pojoList = new ArrayList<Jwellery_pojo>();
    int resource;
   JwelleryHelper dbHelper;

    public JwelleryAdapter(Context context, List<Jwellery_pojo> jwellery_pojoList, int resource) {
        this.context = context;
        this.jwellery_pojoList = jwellery_pojoList;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return jwellery_pojoList.size();
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

            holder.jwelleryname = row.findViewById(R.id.jwellery_product_name);
            holder.jwelleryprice= row.findViewById(R.id.jwellery_product_price);
            holder.jwelleryimg_product = row.findViewById(R.id.jwellery_product_image);

            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }
        final Jwellery_pojo orderInfo = jwellery_pojoList.get(i);

        dbHelper = new JwelleryHelper(context);

        //holder.orderid.setText(orderInfo.getOrderid().toString());


        holder.jwelleryname.setText("Name:"+" "+orderInfo.getJwelleryname());
        holder.jwelleryprice.setText("Price:" + " "+orderInfo.getJwelleryprice());
        Picasso.with(context).load(orderInfo.getJwelleryimage()).into(holder.jwelleryimg_product);


        return row;
    }

    static class ViewHolder {
        TextView jwelleryname,jwelleryprice, jid, jcid;

        ImageView jwelleryimg_product;
    }
}

