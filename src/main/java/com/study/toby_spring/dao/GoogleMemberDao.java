package com.study.toby_spring.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class GoogleMemberDao extends MemberDaoV2{
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        //google 사의 DB connection 생성 코드 구현
        return null;
    }
}

