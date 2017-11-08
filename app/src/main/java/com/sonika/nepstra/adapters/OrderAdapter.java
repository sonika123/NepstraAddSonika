package com.sonika.nepstra.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sonika.nepstra.R;
import com.sonika.nepstra.helpers.OrderHelper;
import com.sonika.nepstra.listener.ListViewListener;
import com.sonika.nepstra.pojo.OrderedProducts_pojo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by sonika on 5/9/2017.
 */

public class OrderAdapter extends BaseAdapter{
    Context context;
    List<OrderedProducts_pojo> objects = new ArrayList<OrderedProducts_pojo>();
    int resource;
    OrderHelper dbHelper;
    private ListViewListener mListener;


    public OrderAdapter(Context context, List<OrderedProducts_pojo> objects, int resource) {
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return objects.size();
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resource, parent, false);
            holder = new ViewHolder();
            holder.name = row.findViewById(R.id.txt_name_add_to_cart);
            holder.price= row.findViewById(R.id.txt_price_add_to_cart);
            holder.img_product = row.findViewById(R.id.img_add_to_cart);
            holder.orderid = row.findViewById(R.id.ordered_productlist_id);
            holder.btnRemove = row.findViewById(R.id.btn_add_to_cart_remove);
            row.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) row.getTag();
        }
        final OrderedProducts_pojo orderInfo = objects.get(position);

        dbHelper = new OrderHelper(context);
        objects = dbHelper.getOrderMessage();

        Log.e("objects",objects.get(position).getOrderedcat_id());

        List<String> listOfID = new ArrayList<>();
        for (int i = 0; i<objects.size(); i++)
        {
            listOfID.add(objects.get(i).getOrderedcat_id());
            Log.e("fish", listOfID.toString());

        }
        holder.name.setText("Name : " +orderInfo.getOrderedname());
        int totalPrice = Integer.valueOf(orderInfo.getOrderedprice()) * orderInfo.count;
        holder.price.setText("Price : " +totalPrice);
        Picasso.with(context).load(orderInfo.getOrderedimage()).into(holder.img_product);
        holder.orderid.setText(orderInfo.count+"");

//        for (int i =0; i<listOfID.size(); i++)
//        {
//
//            Log.e("xiryo", listOfID.get(i));
//            int occurrences = Collections.frequency(listOfID, listOfID.get(i));
//            Log.e("prakriti", listOfID.get(i) + ":" + occurrences);
//            holder.orderid.setText(occurrences+"");
//        }


        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dbHelper.delete(orderInfo.getOrderid().toString(), null, null);
                dbHelper.delete(objects.get(position).getOrderid()
                        .toString(), null, null);
                Toast.makeText(context, "removed", Toast.LENGTH_SHORT).show();
                mListener.getMyTotal();
                objects.remove(position);
                notifyDataSetChanged();
            }
        });
        return row;
    }
    public void setListener(ListViewListener listener) {
        mListener = listener;
    }




    static class ViewHolder {
        TextView name, price, orderid, catid;
        Button btnRemove;
        ImageView img_product;
    }
}