package com.sonika.nepstra.adapters;

import android.content.Context;

import com.sonika.nepstra.helpers.NewArrivalsHelper;
import com.sonika.nepstra.helpers.WomenHelper;
import com.sonika.nepstra.pojo.Newarrivals_pojo;
import com.sonika.nepstra.pojo.WomenPoducts_pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sonika on 10/16/2017.
 */

public class NewArrivalAdapter {
    Context context;
    List<Newarrivals_pojo> newarrivals_pojos = new ArrayList<Newarrivals_pojo>();
    int resource;
    NewArrivalsHelper dbHelper;

    public NewArrivalAdapter(Context context, List<Newarrivals_pojo> newarrivals_pojos, int resource) {
        this.context = context;
        this.newarrivals_pojos = newarrivals_pojos;
        this.resource = resource;
    }
}
