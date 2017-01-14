package com.hanbit.kakao2.service;

import android.content.Context;

import com.hanbit.kakao2.dao.MessageDAO;
import com.hanbit.kakao2.domian.MessageBean;

import java.util.ArrayList;

/**
 * Created by hb2008 on 2017-01-07.
 */

public class MessageServiceImp implements MessageService {

        MessageDAO dao;

    public MessageServiceImp(Context applicationContext) {
        dao = new MessageDAO(applicationContext);



    }

    @Override
    public void write(MessageBean msg) {

    }

    @Override
    public ArrayList<MessageBean> list() {
        return null;
    }

    @Override
    public ArrayList<MessageBean> findBySender(String id) {
        return null;
    }

    @Override
    public MessageBean findBySeq(int seq) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int countByWriter(String id) {
        return 0;
    }

    @Override
    public void updateMsg(MessageBean msg) {

    }

    @Override
    public void deleteMsg(int seq) {

    }
}
