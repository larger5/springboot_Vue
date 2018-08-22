package com.cun.itaem.service.impl;

import com.cun.itaem.dao.HonorDao;
import com.cun.itaem.entity.Honor;
import com.cun.itaem.service.HonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HonorServiceImpl implements HonorService {

    @Autowired
    private HonorDao honorDao;

    @Override
    public Honor getHonorById(Integer id) {
        return honorDao.findOne(id);
    }

    @Override
    public void deleteHonorById(Integer id) {
        honorDao.delete(id);
    }

    @Override
    public List<Honor> getAllHonors() {
        return honorDao.findAll();
    }

    @Override
    public void insertHonor(Honor honor) {
        honorDao.save(honor);
    }

    @Override
    public void updateHonor(Honor honor) {
        honorDao.save(honor);
    }
}
