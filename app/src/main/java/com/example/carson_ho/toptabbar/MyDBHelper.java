package com.example.carson_ho.toptabbar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pclx on 2018/3/3.
 */

public class MyDBHelper extends SQLiteOpenHelper {
    public static final String CREATE_USERDATA="create table userData(" +
            "id integer primary key autoincrement,"
            +"name text,"
            +"ID text,"
            +"Tel text"
            +"password text)";
    private Context mContext;
    public MyDBHelper(Context context, String name, SQLiteDatabase.CursorFactory cursorFactory, int version){
        super(context,name,cursorFactory,version);
        mContext = context;
    }


    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_USERDATA);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
