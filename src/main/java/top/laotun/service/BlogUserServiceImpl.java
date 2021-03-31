package top.laotun.service;

import top.laotun.mapper.BlogUserMapper;
import top.laotun.pojo.BlogUser;

import java.util.Map;

public class BlogUserServiceImpl implements BlogUserService{

    private BlogUserMapper blogUserMapper;

    public void setBlogUserMapper(BlogUserMapper blogUserMapper) {
        this.blogUserMapper = blogUserMapper;
    }

    public BlogUser login(Map<String, Object> map) {
        return blogUserMapper.login(map);
    }

    public int changePassword(Map<String, Object> map) {
        return blogUserMapper.changePassword(map);
    }
}
