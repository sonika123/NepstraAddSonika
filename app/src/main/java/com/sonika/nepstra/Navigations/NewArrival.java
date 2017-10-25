package com.sonika.nepstra.Navigations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sonika.nepstra.R;
import com.sonika.nepstra.adapters.NewArrivalAdapter;
import com.sonika.nepstra.adapters.WomenAdapter;
import com.sonika.nepstra.helpers.NewArrivalsHelper;
import com.sonika.nepstra.helpers.WomenHelper;
import com.sonika.nepstra.pojo.Newarrivals_pojo;
import com.sonika.nepstra.pojo.WomenPoducts_pojo;

import java.util.ArrayList;
import java.util.List;

public class NewArrival extends AppCompatActivity {
    ListView lv;
    NewArrivalsHelper dbhelper;
    NewArrivalAdapter arrivalAdapter;
    List<Newarrivals_pojo> arrivalsPoductsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_arrival);
        dbhelper = new NewArrivalsHelper(this);
        lv = (ListView) findViewById(R.id.newArrival_productlist);
        showNewArrivals();
    }

    private void showNewArrivals() {
        arrivalsPoductsList = dbhelper.getarrivals();
        for (int i = 0; i < arrivalsPoductsList.size(); i++)
        {
            final Newarrivals_pojo info = arrivalsPoductsList.get(i);
            arrivalAdapter = new NewArrivalAdapter(this, arrivalsPoductsList, R.layout.new_arrival_list);
            lv.setAdapter(arrivalAdapter);
            lv.deferNotifyDataSetChanged();
        }
    }
}
