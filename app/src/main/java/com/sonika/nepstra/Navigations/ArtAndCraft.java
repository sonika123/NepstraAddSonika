package com.sonika.nepstra.Navigations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.sonika.nepstra.R;
import com.sonika.nepstra.adapters.ArtAndCraftAdapter;
import com.sonika.nepstra.adapters.NewArrivalAdapter;
import com.sonika.nepstra.helpers.ArtAndCraftHelper;
import com.sonika.nepstra.helpers.NewArrivalsHelper;
import com.sonika.nepstra.pojo.ArtAndCraft_pojo;
import com.sonika.nepstra.pojo.Newarrivals_pojo;

import java.util.ArrayList;
import java.util.List;

public class ArtAndCraft extends AppCompatActivity {
    ListView lv;
    ArtAndCraftHelper dbhelper;
    ArtAndCraftAdapter artandcraftadapter;
    List<ArtAndCraft_pojo> artPoductsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_and_craft);
        dbhelper = new ArtAndCraftHelper(this);
        lv = (ListView) findViewById(R.id.artandcraft_productlist);
        showartProducts();
    }

    private void showartProducts() {
        artPoductsList = dbhelper.getartandcraft();
        for (int i = 0; i < artPoductsList.size(); i++)

        {
            final ArtAndCraft_pojo info = artPoductsList.get(i);
            artandcraftadapter = new ArtAndCraftAdapter(this, artPoductsList,R.layout.artandcraft_list);
            lv.setAdapter(artandcraftadapter);
            lv.deferNotifyDataSetChanged();
        }
    }
}
