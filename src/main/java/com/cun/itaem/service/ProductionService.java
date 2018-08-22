package com.cun.itaem.service;

import com.cun.itaem.entity.Blog;
import com.cun.itaem.entity.Production;

import java.util.List;

public interface ProductionService {

    // 查
    Production getProductionById(Integer id);

    // 删
    void deleteProductionById(Integer id);

    // 全
    List<Production> getAllProductions();

    // 增
    void insertProduction(Production production);

    // 改
    void updateProduction(Production production);
}
