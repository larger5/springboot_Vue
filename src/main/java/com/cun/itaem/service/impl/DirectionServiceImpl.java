package com.cun.itaem.service.impl;

import com.cun.itaem.dao.DirectionDao;
import com.cun.itaem.entity.Blog;
import com.cun.itaem.entity.Direction;
import com.cun.itaem.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    private DirectionDao directionDao;

    @Override
    public Direction getDirectionById(Integer id) {
        return directionDao.findOne(id);
    }

    @Override
    public void deleteDirectionById(Integer id) {
        directionDao.delete(id);
    }

    @Override
    public List<Direction> getAllDirections() {
        return directionDao.findAll();
    }

    @Override
    public void insertDirection(Direction direction) {
        directionDao.save(direction);
    }

    @Override
    public void updateDirection(Direction direction) {
        directionDao.save(direction);
    }
}
