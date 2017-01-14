package com.hanbit.kakao2.service;

import com.hanbit.kakao2.domian.MessageBean;

import java.util.ArrayList;

/**
 * Created by hb2008 on 2017-01-07.
 */

public interface MessageService {

    public void write(MessageBean msg); //createMessage
    public ArrayList<MessageBean> list(); //readAll
    public ArrayList<MessageBean> findBySender(String id); //readGroup
    public MessageBean findBySeq(int seq); // readOne
    public int count(); //readCount
    public int countByWriter(String id); //readCount
    public void updateMsg(MessageBean msg); // updateMessage
    public void deleteMsg(int seq);

}
