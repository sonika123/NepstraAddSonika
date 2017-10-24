package com.sonika.nepstra.Navigations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.sonika.nepstra.R;
import com.sonika.nepstra.adapters.NewArrivalAdapter;
import com.sonika.nepstra.adapters.SportsAdapter;
import com.sonika.nepstra.adapters.WomenAdapter;
import com.sonika.nepstra.helpers.SportsHelper;
import com.sonika.nepstra.helpers.WomenHelper;
import com.sonika.nepstra.pojo.Newarrivals_pojo;
import com.sonika.nepstra.pojo.Sports_pojo;
import com.sonika.nepstra.pojo.WomenPoducts_pojo;

import java.util.ArrayList;
import java.util.List;

public class Sports extends AppCompatActivity {
    ListView lv;
    SportsHelper dbhelper;
    SportsAdapter sportsAdapter;
    List<Sports_pojo> sports_pojoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "Sports Activity", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        lv = (ListView) findViewById(R.id.sports_productlist);
        dbhelper = new SportsHelper(this);
        showSportsProducts();
    }

    private void showSportsProducts() {
        sports_pojoList = dbhelper.getsports();
        for (int i = 0; i < sports_pojoList.size(); i++)

        {
            final Sports_pojo info1 = sports_pojoList.get(i);
            sportsAdapter = new SportsAdapter(this, sports_pojoList, R.layout.sports_list);
            lv.setAdapter(sportsAdapter);
            lv.deferNotifyDataSetChanged();
        }
    }
}
