package top.laotun.mapper;

import top.laotun.pojo.BlogUser;

import java.util.Map;

public interface BlogUserMapper {
    public BlogUser login(Map<String, Object> map);
    public int changePassword(Map<String, Object> map);
}
