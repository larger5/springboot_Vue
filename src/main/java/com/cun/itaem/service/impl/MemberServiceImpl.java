package com.cun.itaem.service.impl;

import com.cun.itaem.dao.MemberDao;
import com.cun.itaem.entity.Member;
import com.cun.itaem.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public Member getMemberById(Integer id) {
        return memberDao.findOne(id);
    }

    @Override
    public void deleteMemberById(Integer id) {
        memberDao.delete(id);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberDao.findAll();
    }

    @Override
    public void insertMember(Member member) {
        memberDao.save(member);
    }

    @Override
    public void updateMember(Member member) {
        memberDao.save(member);
    }
}
