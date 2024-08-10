package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createUserTable = "CREATE TABLE users (username TEXT, email TEXT, password TEXT)";
        sqLiteDatabase.execSQL(createUserTable);

        String createCartTable = "CREATE TABLE cart (username TEXT, product TEXT, price FLOAT, otype TEXT)";
        sqLiteDatabase.execSQL(createCartTable);

        String createOrderTable = "CREATE TABLE orderplace (username TEXT, fullname TEXT, address TEXT, contactno TEXT, pincode INTEGER, date TEXT, time TEXT, amount FLOAT, otype TEXT)";
        sqLiteDatabase.execSQL(createOrderTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cart");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS orderplace");
        onCreate(sqLiteDatabase);
    }

    public void register(String username, String email, String password) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email", email);
        values.put("password", password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, values);
        db.close();
    }

    public int login(String username, String password) {
        String[] selectionArgs = {username, password};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", selectionArgs);
        int result = cursor.moveToFirst() ? 1 : 0;
        cursor.close();
        db.close();
        return result;
    }

    public void addCart(String username, String product, float price, String otype) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("product", product);
        values.put("price", price);
        values.put("otype", otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("cart", null, values);
        db.close();
    }

    public int checkCart(String username, String product) {
        String[] selectionArgs = {username, product};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cart WHERE username = ? AND product = ?", selectionArgs);
        int result = cursor.moveToFirst() ? 1 : 0;
        cursor.close();
        db.close();
        return result;
    }

    public void removeCart(String username, String otype) {
        String[] whereArgs = {username, otype};
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart", "username = ? AND otype = ?", whereArgs);
        db.close();
    }

    public ArrayList<String> getCardData(String username, String otype) {
        ArrayList<String> data = new ArrayList<>();
        String[] selectionArgs = {username, otype};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM cart WHERE username = ? AND otype = ?", selectionArgs);
        if (cursor.moveToFirst()) {
            do {
                String product = cursor.getString(1);
                String price = cursor.getString(2);
                data.add(product + "$" + price);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return data;
    }

    public void addOrder(String username, String fullname, String address, String contact, int pincode, String date, String time, float price, String otype) {
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("fullname", fullname);
        values.put("address", address);
        values.put("contactno", contact);
        values.put("pincode", pincode);
        values.put("date", date);
        values.put("time", time);
        values.put("amount", price);
        values.put("otype", otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("orderplace", null, values);
        db.close();
    }

    public ArrayList<String> getOrderData(String username) {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] str = {username};
        Cursor c = db.rawQuery("SELECT * FROM orderplace WHERE username = ?", str);
        if (c.moveToFirst()) {
            do {
                arr.add(c.getString(1) + "$" + c.getString(2) + "$" + c.getString(3) + "$" + c.getString(4) + "$" + c.getString(5) + "$" + c.getString(6) + "$" + c.getString(7) + "$" + c.getString(8));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return arr;
    }

    public int checkAppointmentExists(String username, String fullname, String address, String contact, String date, String time) {
        String[] selectionArgs = {username, fullname, address, contact, date, time};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM orderplace WHERE username = ? AND fullname = ? AND address = ? AND contactno = ? AND date = ? AND time = ?", selectionArgs);
        int result = cursor.moveToFirst() ? 1 : 0;
        cursor.close();
        db.close();
        return result;
    }
}
