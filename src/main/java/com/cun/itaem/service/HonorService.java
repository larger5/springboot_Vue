package com.cun.itaem.service;

import com.cun.itaem.entity.Honor;

import java.util.List;

public interface HonorService {

    // 查
    Honor getHonorById(Integer id);

    // 删
    void deleteHonorById(Integer id);

    // 全
    List<Honor> getAllHonors();

    // 增
    void insertHonor(Honor honor);

    // 改
    void updateHonor(Honor honor);
}
