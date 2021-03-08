package top.laotun.service;

import top.laotun.pojo.BlogUser;
import java.util.Map;


public interface BlogUserService {
    public BlogUser login(Map<String, Object> map);
}
