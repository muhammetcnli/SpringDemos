package com.atlas.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public boolean addSillyMember() {

        System.out.println(getClass() + ": Doing db work: adding a silly account");

        return true;
    }

}
