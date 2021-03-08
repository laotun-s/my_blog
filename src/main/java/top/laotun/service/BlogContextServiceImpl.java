package top.laotun.service;

import top.laotun.mapper.BlogContextMapper;
import top.laotun.pojo.BlogContent;

import java.util.ArrayList;
import java.util.List;

public class BlogContextServiceImpl implements BlogContextService{
    private BlogContextMapper blogContextMapper;

    public void setBlogContextMapper(BlogContextMapper blogContextMapper) {
        this.blogContextMapper = blogContextMapper;
    }

    public ArrayList<BlogContent> showContext() {
        return blogContextMapper.showContext();
    }

}
