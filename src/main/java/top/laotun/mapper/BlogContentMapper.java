package top.laotun.mapper;

import top.laotun.pojo.BlogContent;

import java.util.ArrayList;
import java.util.Map;

public interface BlogContentMapper {
    public ArrayList<BlogContent> showContent(Map<String, Object> map);
    public int saveContent(Map<String, Object> map);
    public int updateContent(Map<String, Object> map);
    public int deleteContent(int id);
}
