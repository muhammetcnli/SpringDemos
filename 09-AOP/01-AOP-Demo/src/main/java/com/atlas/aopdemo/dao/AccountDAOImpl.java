package com.atlas.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount() {

        System.out.println(getClass() + ": Doing db work: adding account");
    }
}
