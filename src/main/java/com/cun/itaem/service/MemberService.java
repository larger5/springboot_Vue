package com.cun.itaem.service;

import com.cun.itaem.entity.Blog;
import com.cun.itaem.entity.Member;

import java.util.List;

public interface MemberService {

    // 查
    Member getMemberById(Integer id);

    // 删
    void deleteMemberById(Integer id);

    // 全
    List<Member> getAllMembers();

    // 增
    void insertMember(Member member);

    // 改
    void updateMember(Member member);
}
