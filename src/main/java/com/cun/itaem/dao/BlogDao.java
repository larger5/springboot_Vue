package com.cun.itaem.dao;

import com.cun.itaem.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<Blog,Integer> {
}
