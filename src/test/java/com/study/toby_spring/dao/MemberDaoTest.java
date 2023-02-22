package com.study.toby_spring.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberDaoTest {

    @BeforeEach
    void before() throws Exception{
        MemberDao memberDao = new MemberDao();
        memberDao.deleteAll();
    }

    @Test
    @DisplayName("connection")
    void connectionTest() throws Exception {
        //given
        MemberDao memberDao = new MemberDao();

        Member member = new Member();
        member.setId("member1");
        member.setName("tester");
        member.setPassword("test1234");

        //when
        memberDao.save(member);
        System.out.println("Save Member id ="+member.getId());

        Member getMember = memberDao.findById(member.getId());
        //then
        System.out.println("Fine Member id= "+getMember.getId());
    }
}