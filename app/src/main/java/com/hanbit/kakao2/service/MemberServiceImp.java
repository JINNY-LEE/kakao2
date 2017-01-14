package com.hanbit.kakao2.service;

import android.content.Context;

import com.hanbit.kakao2.dao.MemberDAO;
import com.hanbit.kakao2.domian.MemberBean;

import java.util.ArrayList;

/**
 * Created by hb2008 on 2017-01-07.
 */

public class MemberServiceImp implements MemberService {

    MemberDAO dao;
    MemberBean session;


    public MemberServiceImp(Context applicationContext) {
        dao = new MemberDAO(applicationContext);

    }

    @Override
    public void register(MemberBean param) {

    }

    @Override
    public ArrayList<MemberBean> list() {
        return null;
    }

    @Override
    public ArrayList<MemberBean> searchByName(String name) {
        return null;
    }

    @Override
    public MemberBean searchById(String id) {
        return null;
    }

    @Override
    public boolean login(MemberBean param) {
        boolean flag = false;
        session = dao.login(param);
        if ( session.getId().equals("fail")){
            flag = false;
        } else{
            flag = true;

        }
        return flag;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public void modify(MemberBean param) {

    }

    @Override
    public void unregister(String id) {

    }
}
