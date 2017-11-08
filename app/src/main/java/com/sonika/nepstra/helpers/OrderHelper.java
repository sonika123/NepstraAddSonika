package com.sonika.nepstra.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.sonika.nepstra.pojo.OrderedProducts_pojo;

import java.util.ArrayList;

/**
 * Created by sonika on 10/15/2017.
 */

public class OrderHelper extends SQLiteOpenHelper {
    static int DATABASE_VERSION = 2;
    static String DATABASE_NAME = "user_orders";

    String ORDER_TABLE = "CREATE TABLE if not exists `user_orders`  (\n" +
            "                       `id` INTEGER PRIMARY KEY ,\n" +
            "                       `name` TEXT,\n" +
            "                       `count` INTEGER,\n" +
            "                       `cat_id` TEXT,\n" +
            "                       `price` TEXT,\n" +
            "                       `imageone` TEXT\n" +
            "                      );";

    public OrderHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        getWritableDatabase().execSQL(ORDER_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertOrderInfo(ContentValues cv) {


        getWritableDatabase().insert("user_orders", "", cv);
        Log.e("insertvaeraxa", "yes1");

    }

    public ArrayList<OrderedProducts_pojo> getOrderMessage() {
        Log.e("getOrderMessage", "vaeraxa");
        String sql = "select * from user_orders";
        ArrayList<OrderedProducts_pojo> list = new ArrayList<OrderedProducts_pojo>();
        Cursor cursor = getWritableDatabase().rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Log.e("movettonext", "yes");
            // Do Somehing here
            OrderedProducts_pojo orderinfo = new OrderedProducts_pojo();
            orderinfo.orderid = cursor.getInt(cursor.getColumnIndex("id"));
            orderinfo.orderedname = cursor.getString(cursor.getColumnIndex("name"));
            orderinfo.count = cursor.getInt(cursor.getColumnIndex("count"));
            orderinfo.orderedcat_id = cursor.getString(cursor.getColumnIndex("cat_id"));
            orderinfo.orderedprice = cursor.getString(cursor.getColumnIndex("price"));
            orderinfo.orderedimage = cursor.getString(cursor.getColumnIndex("imageone"));
            list.add(orderinfo);
        }
        cursor.close();
        return list;
    }


    //    public void delete(String id, Object name, Object amount) {
//        getWritableDatabase().delete("user_order", "id = ?" +id, new String[] { String.valueOf(id) });
//        Log.e("deletinsqlite", "ghijklmnop");
//    }
    public void delete(String id, Object name, Object amount) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("delete from user_orders where id=" + id);
            db.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public String GetTotal() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor GetTotal = db.rawQuery("SELECT Sum(price) AS myTotal FROM  user_orders", null);
        String result = " ";
        while (GetTotal.moveToNext()) {
            result = String.valueOf(GetTotal.getDouble(GetTotal.getColumnIndex("myTotal")));
        }
        return result;
    }

}
