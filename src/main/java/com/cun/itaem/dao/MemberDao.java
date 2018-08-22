package com.cun.itaem.dao;

import com.cun.itaem.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member,Integer> {
}
