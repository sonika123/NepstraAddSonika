package com.sonika.nepstra.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sonika.nepstra.Navigations.ArtAndCraft;
import com.sonika.nepstra.R;
import com.sonika.nepstra.helpers.ArtAndCraftHelper;
import com.sonika.nepstra.helpers.NewArrivalsHelper;
import com.sonika.nepstra.pojo.ArtAndCraft_pojo;
import com.sonika.nepstra.pojo.Newarrivals_pojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 10/17/2017.
 */

public class ArtAndCraftAdapter extends BaseAdapter {
    Context context;
    List<ArtAndCraft_pojo> artAndCraft_pojos = new ArrayList<ArtAndCraft_pojo>();
    int resource;
    ArtAndCraftHelper dbHelper;

    public ArtAndCraftAdapter(Context context, List<ArtAndCraft_pojo> artAndCraft_pojos, int resource) {
        this.context = context;
        this.artAndCraft_pojos = artAndCraft_pojos;
        this.resource = resource;
    }


    @Override
    public int getCount() {
        return artAndCraft_pojos.size();
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

            holder.artname = row.findViewById(R.id.artandcraft_product_name);
            holder.artprice= row.findViewById(R.id.artandcraft_product_price);
            holder.artimg_product = row.findViewById(R.id.artandcraft_product_image);

            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }
        final ArtAndCraft_pojo orderInfo = artAndCraft_pojos.get(i);

        dbHelper = new ArtAndCraftHelper(context);

        //holder.orderid.setText(orderInfo.getOrderid().toString());


        holder.artname.setText("Name:"+" "+orderInfo.getArtname());
        holder.artprice.setText("Price:" + " "+orderInfo.getArtprice());
        Picasso.with(context).load(orderInfo.getArtimage()).into(holder.artimg_product);


        return row;
    }

    static class ViewHolder {
        TextView artname, artprice, artid, artcid;

        ImageView artimg_product;
    }
    }
