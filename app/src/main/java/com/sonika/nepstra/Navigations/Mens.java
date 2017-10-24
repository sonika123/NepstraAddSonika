package com.sonika.nepstra.Navigations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.sonika.nepstra.R;
import com.sonika.nepstra.adapters.ArtAndCraftAdapter;
import com.sonika.nepstra.adapters.MensAdapter;
import com.sonika.nepstra.helpers.ArtAndCraftHelper;
import com.sonika.nepstra.helpers.MensHelper;
import com.sonika.nepstra.pojo.ArtAndCraft_pojo;
import com.sonika.nepstra.pojo.Mens_pojo;

import java.util.ArrayList;
import java.util.List;

public class Mens extends AppCompatActivity {
    ListView lv;
    MensHelper dbhelper;
    MensAdapter mensAdapter;
    List<Mens_pojo> mensPojoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "Mens Category", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens);
        dbhelper = new MensHelper(this);
        lv = (ListView) findViewById(R.id.mens_productlist);
        showmenProducts();
    }

    private void showmenProducts() {
        mensPojoList = dbhelper.getmen();
        for (int i = 0; i < mensPojoList.size(); i++)
        {
            final Mens_pojo info = mensPojoList.get(i);
            mensAdapter = new MensAdapter(this, mensPojoList,R.layout.mens_list);
            lv.setAdapter(mensAdapter);
            lv.deferNotifyDataSetChanged();
        }
    }
}
