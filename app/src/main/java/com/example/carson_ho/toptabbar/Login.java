package com.example.carson_ho.toptabbar;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener{
    private MyDBHelper dbHelper;
    private EditText username;
    private EditText id;
    private EditText tel;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        dbHelper = new MyDBHelper(this,"UserStore.db",null,1);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        replaceFragment1(new Fragment01());
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button1:
                replaceFragment1(new Fragment01());
                break;
            case R.id.button2:
                replaceFragment2(new Fragment02());
                break;
            case R.id.button3:
                Intent intent1 = new Intent(Login.this,MainActivity.class);
                id = (EditText)findViewById(R.id.editText1);
                tel = (EditText)findViewById(R.id.editText2);
                password = (EditText)findViewById(R.id.editText3);
                String id1 = id.getText().toString();
                String tel1 = tel.getText().toString();
                String password1 = password.getText().toString();
                if (login1(id1,tel1,password1)){
                    Toast.makeText(Login.this,"登录成功",Toast.LENGTH_SHORT).show();
                    startActivity(intent1);
                }
                else {
                    Toast.makeText(Login.this,"登录失败",Toast.LENGTH_SHORT).show();
                }
            case R.id.button4:
                login2(v);
            default:
                break;
        }
    }
    public boolean login1(String id, String tel, String password){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "selsct * from userData where id=? and tel=? and password=?";
        Cursor cursor1 = db.rawQuery(sql,new String[]{id,tel});
        Cursor cursor2 = db.rawQuery(sql,new String[]{id,password});
        if ((cursor1.moveToFirst())&&cursor2.moveToFirst()){
            cursor1.close();
            cursor2.close();
            return true;
        }
        return false;
    }
    public void login2(View v){
        Intent intent2 = new Intent(Login.this,MainActivity.class);
        EditText editText4 = (EditText)findViewById(R.id.editText4);
        EditText editText5 = (EditText)findViewById(R.id.editText5);
        EditText editText6 = (EditText)findViewById(R.id.editText6);
        EditText editText7 = (EditText)findViewById(R.id.editText7);
        String newname = editText4.getText().toString();
        String newid = editText5.getText().toString();
        String newtel = editText6.getText().toString();
        String newpassword = editText7.getText().toString();
        if(CheckData(newtel,newid)){
            Toast.makeText(this,"该学号/号码已被注册，注册失败",Toast.LENGTH_SHORT).show();
        }
        else {
            if(register(newname,newid,newtel,newpassword)){
                Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
                startActivity(intent2);
            }
        }
    }
    public boolean register(String name,String id,String tel,String password){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("id",id);
        values.put("tel",tel);
        values.put("password",password);
        db.insert("userDate",null,values);
        db.close();
        return true;
    }
    public boolean CheckData(String tel,String id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String Query = "Select * from userData where id or tel =?";
        Cursor cursor3 = db.rawQuery(Query,new String[]{tel});
        Cursor cursor4 = db.rawQuery(Query,new String[]{id});
        if( (cursor3.getCount()>0)||(cursor4.getCount()>0)){
            cursor3.close();
            cursor4.close();
            return true;
        }
        cursor3.close();
        cursor4.close();
        return false;
    }

    private void replaceFragment1(Fragment fragment){
        FragmentManager fragmentManager1 = getFragmentManager();
        FragmentTransaction transaction1 = fragmentManager1.beginTransaction();
        transaction1.replace(R.id.fragment01,fragment);
        transaction1.commit();
    }
    private void replaceFragment2(Fragment fragment){
        FragmentManager fragmentManager2 = getFragmentManager();
        FragmentTransaction transaction2 = fragmentManager2.beginTransaction();
        transaction2.replace(R.id.fragment01,fragment);
        transaction2.commit();
    }
}
