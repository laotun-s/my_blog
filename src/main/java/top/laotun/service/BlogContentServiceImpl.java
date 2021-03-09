package top.laotun.service;


import top.laotun.mapper.BlogContentMapper;
import top.laotun.pojo.BlogContent;

import java.util.ArrayList;

public class BlogContentServiceImpl implements BlogContentService{
    private BlogContentMapper blogContentMapper;

    public void setBlogContentMapper(BlogContentMapper blogContentMapper) {
        this.blogContentMapper = blogContentMapper;
    }

    public ArrayList<BlogContent> showContent() {
        return blogContentMapper.showContent();
    }

}
