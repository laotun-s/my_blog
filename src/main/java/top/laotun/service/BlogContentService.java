package top.laotun.service;

import top.laotun.pojo.BlogContent;

import java.util.ArrayList;
import java.util.Map;

public interface BlogContentService {
    public ArrayList<BlogContent> showContent();
    public int saveContent(Map<String, Object> map);
}
