package com.sonika.nepstra.Navigations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.sonika.nepstra.R;
import com.sonika.nepstra.adapters.JwelleryAdapter;
import com.sonika.nepstra.adapters.KidsAdapter;
import com.sonika.nepstra.adapters.NewArrivalAdapter;
import com.sonika.nepstra.helpers.JwelleryHelper;
import com.sonika.nepstra.helpers.KidsHelper;
import com.sonika.nepstra.helpers.NewArrivalsHelper;
import com.sonika.nepstra.pojo.Jwellery_pojo;
import com.sonika.nepstra.pojo.Kids_pojo;
import com.sonika.nepstra.pojo.Newarrivals_pojo;

import java.util.ArrayList;
import java.util.List;

public class Kids extends AppCompatActivity {
    ListView lv;
    KidsHelper dbhelper;
    KidsAdapter kidsAdapter;
    List<Kids_pojo> kidslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "Kids Activity here", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kids);
        dbhelper = new KidsHelper(this);
        lv = (ListView) findViewById(R.id.kids_productlist);
        showKidsProducts();
    }

    private void showKidsProducts() {
        kidslist = dbhelper.getkids();
        for (int i = 0; i < kidslist.size(); i++)

        {
            final Kids_pojo info = kidslist.get(i);
            kidsAdapter = new KidsAdapter(this, kidslist, R.layout.kids_list);
            lv.setAdapter(kidsAdapter);
            lv.deferNotifyDataSetChanged();
        }
    }
}
