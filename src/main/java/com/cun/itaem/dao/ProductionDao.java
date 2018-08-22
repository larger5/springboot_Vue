package com.cun.itaem.dao;

import com.cun.itaem.entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionDao extends JpaRepository<Production,Integer> {
}
