package com.sonika.nepstra.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sonika.nepstra.Navigations.NewArrival;
import com.sonika.nepstra.R;
import com.sonika.nepstra.helpers.NewArrivalsHelper;
import com.sonika.nepstra.helpers.WomenHelper;
import com.sonika.nepstra.pojo.Jwellery_pojo;
import com.sonika.nepstra.pojo.Newarrivals_pojo;
import com.sonika.nepstra.pojo.WomenPoducts_pojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 10/16/2017.
 */

public class NewArrivalAdapter extends BaseAdapter{
    Context context;
    List<Newarrivals_pojo> newarrivals_pojos = new ArrayList<Newarrivals_pojo>();
    int resource;
    NewArrivalsHelper dbHelper;

    public NewArrivalAdapter(Context context, List<Newarrivals_pojo> newarrivals_pojos, int resource) {
        this.context = context;
        this.newarrivals_pojos = newarrivals_pojos;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return newarrivals_pojos.size();
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

            holder.newname = row.findViewById(R.id.newArrival_product_name);
            holder.newprice= row.findViewById(R.id.newArrival_product_price);
            holder.newimg_product = row.findViewById(R.id.newArrival_product_image);

            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }
        final Newarrivals_pojo orderInfo = newarrivals_pojos.get(i);

        dbHelper = new NewArrivalsHelper(context);

        //holder.orderid.setText(orderInfo.getOrderid().toString());


        holder.newname.setText("Name:"+" "+orderInfo.getNewname());
        holder.newprice.setText("Price:" + " "+orderInfo.getNewprice());
        Picasso.with(context).load(orderInfo.getNewimage()).into(holder.newimg_product);


        return row;
    }

    static class ViewHolder {
        TextView newname, newprice, newid, newcid;

        ImageView newimg_product;
    }
    }

