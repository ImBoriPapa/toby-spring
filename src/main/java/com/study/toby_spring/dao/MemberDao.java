package com.study.toby_spring.dao;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;

@Slf4j
public class MemberDao {
    public void save(Member member) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        String sql = "insert into member(id,name,password) values (?,?,?)";
        log.info("[QUERY]= {}", sql);
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, member.getId());
        ps.setString(2, member.getName());
        ps.setString(3, member.getPassword());

        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public Member findById(String id) throws ClassNotFoundException, SQLException {
        Connection c = getConnection();
        String sql = "select * from member where id=?";
        log.info("[QUERY]= {}", sql);
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        Member member = new Member();
        member.setId(rs.getString("id"));
        member.setName(rs.getString("name"));
        member.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return member;
    }

    /**
     * extract method
     * 커넥션 분리
     */
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/toby", "root", "0209"
        );
        return c;
    }
}
