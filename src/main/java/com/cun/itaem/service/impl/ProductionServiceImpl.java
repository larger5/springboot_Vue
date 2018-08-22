package com.cun.itaem.service.impl;

import com.cun.itaem.dao.ProductionDao;
import com.cun.itaem.entity.Production;
import com.cun.itaem.service.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionDao productionDao;

    @Override
    public Production getProductionById(Integer id) {
        return productionDao.findOne(id);
    }

    @Override
    public void deleteProductionById(Integer id) {
        productionDao.delete(id);
    }

    @Override
    public List<Production> getAllProductions() {
        return productionDao.findAll();
    }

    @Override
    public void insertProduction(Production production) {
        productionDao.save(production);
    }

    @Override
    public void updateProduction(Production production) {
        productionDao.save(production);
    }
}
