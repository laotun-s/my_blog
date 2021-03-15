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

    public ArrayList<BlogContent> showContent(Map<String, Object> map) {
        return blogContentMapper.showContent(map);
    }

    public int saveContent(Map<String, Object> map) {
        return blogContentMapper.saveContent(map);
    }

    public int updateContent(Map<String, Object> map) {
        return blogContentMapper.updateContent(map);
    }

}
