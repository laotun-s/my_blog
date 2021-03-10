package top.laotun.service;


import top.laotun.mapper.BlogContentMapper;
import top.laotun.pojo.BlogContent;

import java.util.ArrayList;
import java.util.Map;

public class BlogContentServiceImpl implements BlogContentService{
    private BlogContentMapper blogContentMapper;

    public void setBlogContentMapper(BlogContentMapper blogContentMapper) {
        this.blogContentMapper = blogContentMapper;
    }

    public ArrayList<BlogContent> showContent() {
        return blogContentMapper.showContent();
    }

    public ArrayList<BlogContent> showContent(int id){
        return blogContentMapper.showContent(id);
    }

    public int saveContent(Map<String, Object> map) {
        return blogContentMapper.saveContent(map);
    }

}
