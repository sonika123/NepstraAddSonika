package com.sonika.nepstra.Navigations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.sonika.nepstra.R;
import com.sonika.nepstra.adapters.JwelleryAdapter;
import com.sonika.nepstra.adapters.NewArrivalAdapter;
import com.sonika.nepstra.helpers.JwelleryHelper;
import com.sonika.nepstra.helpers.NewArrivalsHelper;
import com.sonika.nepstra.pojo.Jwellery_pojo;
import com.sonika.nepstra.pojo.Newarrivals_pojo;

import java.util.ArrayList;
import java.util.List;

public class Jwellery extends AppCompatActivity {
    ListView lv;
    JwelleryHelper dbhelper;
    JwelleryAdapter jwelleryAdapter;
    List<Jwellery_pojo> jwellery_pojoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "jwellery activity", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jwellery);
        dbhelper = new JwelleryHelper(this);
        lv = (ListView) findViewById(R.id.jwellery_productlist);
        showJwelleryProducts();
    }

    private void showJwelleryProducts() {
        jwellery_pojoList = dbhelper.getjwellery();
        for (int i = 0; i < jwellery_pojoList.size(); i++)

        {
            final Jwellery_pojo info = jwellery_pojoList.get(i);
            jwelleryAdapter = new JwelleryAdapter(this, jwellery_pojoList, R.layout.jwellery_list);
            lv.setAdapter(jwelleryAdapter);
            lv.deferNotifyDataSetChanged();
        }
    }
}
