package top.laotun.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import top.laotun.Utils.JsonUtils;
import top.laotun.pojo.BlogContent;
import top.laotun.service.BlogContentService;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BlogContenController {
    @Autowired
    @Qualifier("BlogContentServiceImpl")
    private BlogContentService blogContentService;

    /**
     * 首页获取文章
     * @return
     */
    @PostMapping("/content")
    public String showContent(){

        ArrayList<BlogContent> contents = blogContentService.showContent();

        for (BlogContent content : contents) {
            content.setPostContent(null);
            if (content.getPostContentFiltered().length() > 50){
                content.setPostContentFiltered(content.getPostContentFiltered().substring(0, 50));
            }else {
                content.setPostContentFiltered(content.getPostContentFiltered().substring(0, content.getPostContentFiltered().length()-1));
            }
        }

        return JsonUtils.getJson(contents);
    }

    /**
     * 写文章
     * @param request
     * @param postContent
     * @param postContentFiltered
     * @param postTitle
     * @param url
     * @return
     */
    @PostMapping("/editormd")
    public String saveEditor(HttpServletRequest request, @Param("postContent") String postContent, @Param("postContentFiltered") String postContentFiltered, @Param("postTitle") String postTitle, @Param("url") String url){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("postContent", postContent);
        map.put("postContentFiltered", postContentFiltered);
        map.put("postTitle", postTitle);
        try {
            map.put("postName", URLEncoder.encode(postTitle, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        map.put("postAuthor", 1);
        map.put("postClassify", "test");

        map.put("guid", url);

        blogContentService.saveContent(map);

        Object id = map.get("id");
        url = "http://" + url + "/content.html/?id=" + id;
        map.clear();
        map.put("guid", url);
        map.put("id", id);
        blogContentService.updateContent(map);

        return JsonUtils.getJson("ok");
    }

    /**
     * 获取文章内容
     * @param id
     * @return
     */
    @PostMapping("/p/{id}")
    public String content(@PathVariable("id") int id){
        ArrayList<BlogContent> blogContents = blogContentService.showContent(id);

        return JsonUtils.getJson(blogContents.get(0));
    }
}
