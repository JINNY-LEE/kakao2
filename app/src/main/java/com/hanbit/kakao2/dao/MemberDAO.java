package com.hanbit.kakao2.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hanbit.kakao2.domian.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2008 on 2017-01-07.
 */

public class MemberDAO extends SQLiteOpenHelper {

    /*public MemberDAO(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }*/

    public MemberDAO(Context applicationContext) {

        super(applicationContext,"hanbit.db",null,1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists Member(\n" +
                "\tid text primary key,\n" +
                "    pw text ,\n" +
                "    name text,\n" +
                "    email text,\n" +
                "    phone text,\n" +
                "    photo text,\n" +
                "    address text\n" +
                ")\n");
        db.execSQL("create table Message(\n" +
                "\n" +
                "    _id integer primary key autoincrement,\n" +
                "\n" +
                "    sender text ,\n" +
                "\n" +
                "    receiver text,\n" +
                "\n" +
                "    content text,\n" +
                "\n" +
                "    write_time text,\n" +
                "\n" +
                "    id text,\n" +
                "\n" +
                "    foreign key(id) references Member(id)\n" +
                "    )\n");
        //객체를 만듦

        db.execSQL("\n" +
                "insert into Member( id, pw, name, email, phone, photo, address )\n" +
                "values('hong','1','홍길동','hong@test.com','010-3313-0113','default.jpg','서울')\n");
        db.execSQL("\n" +
                "insert into Member( id, pw, name, email, phone, photo, address )\n" +
                "values('kim','2','김유신','kim@test.com','010-1111-1111','default2.jpg','경기')\n");
        db.execSQL("\n" +
                "insert into Member( id, pw, name, email, phone, photo, address )\n" +
                "values('lee','3','이재영','lee@test.com','010-3313-0113','default3.jpg','대구')\n");
        db.execSQL("\n" +
                "insert into Member( id, pw, name, email, phone, photo, address )\n" +
                "values('yoon','4','윤종신','yoon@test.com','010-3313-0113','default4.jpg','부산')\n");
        db.execSQL("\n" +
                "insert into Member( id, pw, name, email, phone, photo, address )\n" +
                "values('jeong','5','정호준','jeong@test.com','010-3313-0113','default5.jpg','강릉')\n");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(MemberBean param) {
        String sql = "";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();


    }
    public ArrayList<MemberBean> selectAll(){ // readAll
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        String sql = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);


        return list;

    }
    public ArrayList<MemberBean> selectByName(String name){ //readGroup
        ArrayList<MemberBean> list = new ArrayList<MemberBean>();
        String sql = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        return list;

    }
    public MemberBean selectById(String id){ //readOne
        MemberBean member = new MemberBean();
        String sql = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        return member;
    }

    public MemberBean login(MemberBean param){
        MemberBean member = new MemberBean();
        String sql = "select id, pw, name, email, phone, photo, address from Member\n" +
                "where id ='"+param.getId()+"' and pw='"+param.getPw()+"'\n";
        Log.d("login SQL:",sql);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToNext()){
            member.setId(cursor.getString(0));
            member.setPw(cursor.getString(1));
            member.setName(cursor.getString(2));
            member.setEmail(cursor.getString(3));
            member.setPhone(cursor.getString(4));
            member.setPhoto(cursor.getString(5));
            member.setAddress(cursor.getString(6));
        } else{
            member.setId("fail");
        }

        Log.d("login result:",member.getId());
        return member;

    }
    public int count(){  //readCount
        int count = 0;
        String sql = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        return count ;

    }
    public void update(MemberBean param) { // updateMember
        String sql = "";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();


    }
    public void delete(String id) { //updateMember
        String sql = "";
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
        db.close();

    }


}
