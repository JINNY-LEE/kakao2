package com.hanbit.kakao2.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hanbit.kakao2.domian.MessageBean;

import java.util.ArrayList;

/**
 * Created by hb2008 on 2017-01-07.
 */

public class MessageDAO extends SQLiteOpenHelper {

    public MessageDAO(Context applicationContext) {
        super(applicationContext,"hanbit.db",null,1);
        this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("\n" +
                "create table Message(\n" +
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

        db.execSQL("insert into Message(sender,receiver,content,write_time,id)\n" +
                "values ('lee','jeong','hello. please call me later','2017-01-07 15:00','lee')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void write(MessageBean msg){ //createMessage
    }

    public ArrayList<MessageBean> selectAll(){ //readAll

        ArrayList<MessageBean> list = new ArrayList<MessageBean>();

        return list;
    }

    public ArrayList<MessageBean> selectBySender(String id){ //readGroup
        ArrayList<MessageBean> list = new ArrayList<MessageBean>();

        return list;

    }

    public MessageBean selectBySeq(int seq){ // readOne
        MessageBean message = new MessageBean();

        return message;

    }
    public int count(){ //readCount

        int count = 0;

        return count;
    }

    public int countByWriter(String id){ //readCount
        int count = 0;

        return count;
    }
    public void updateMsg(MessageBean msg){

    }
    public void deleteMsg(int seq){
    }


}

