package com.cun.itaem.service.impl;

import com.cun.itaem.dao.BlogDao;
import com.cun.itaem.entity.Blog;
import com.cun.itaem.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog getBlogById(Integer id) {
        return blogDao.getOne(id);
    }

    @Override
    public void deleteBlogById(Integer id) {
        blogDao.delete(id);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return blogDao.findAll();
    }

    @Override
    public void insertBlog(Blog blog) {
        blogDao.save(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogDao.save(blog);
    }
}
