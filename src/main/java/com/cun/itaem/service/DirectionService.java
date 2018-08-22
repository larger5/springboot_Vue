package com.cun.itaem.service;

import com.cun.itaem.entity.Blog;
import com.cun.itaem.entity.Direction;

import java.util.List;

public interface DirectionService {

    // 查
    Direction getDirectionById(Integer id);

    // 删
    void deleteDirectionById(Integer id);

    // 全
    List<Direction> getAllDirections();

    // 增
    void insertDirection(Direction direction);

    // 改
    void updateDirection(Direction direction);
}
