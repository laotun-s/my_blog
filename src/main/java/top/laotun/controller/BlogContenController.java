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

        ArrayList<BlogContent> contents = blogContentService.showContent(null);

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
    public String saveEditor(HttpServletRequest request, @Param("postContent") String postContent, @Param("postContentFiltered") String postContentFiltered, @Param("postTitle") String postTitle, @Param("url") String url, @Param("classify") String classify, @Param("id") Integer id){
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
        map.put("postClassify", classify);
        map.put("guid", url);

        if (id == -1){
            blogContentService.saveContent(map);
            Object i = map.get("id");
            url = "http://" + url + "/content.html?id=" + i;
            map.clear();
            map.put("guid", url);
            map.put("id", i);
            blogContentService.updateContent(map);
        }
        else blogContentService.updateContent(map);

        return JsonUtils.getJson("ok");
    }

    /**
     * 获取文章内容
     * @param id
     * @return
     */
    @PostMapping("/p/{id}")
    public String content(@PathVariable("id") int id){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        ArrayList<BlogContent> blogContents = blogContentService.showContent(map);

        //访问一次增加一个点击量
        map.put("click", blogContents.get(0).getPostClick() + 1);
        blogContentService.updateContent(map);

        return JsonUtils.getJson(blogContents.get(0));
    }

    /**
     * 分类查看文章
     * @param page
     * @return
     */
    @PostMapping("/content/{page}")
    public String showContentPage(@PathVariable("page") String page){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);

        ArrayList<BlogContent> blogContents = blogContentService.showContent(map);

        for (BlogContent content : blogContents) {
            content.setPostContent(null);
            if (content.getPostContentFiltered().length() > 50){
                content.setPostContentFiltered(content.getPostContentFiltered().substring(0, 50));
            }else {
                content.setPostContentFiltered(content.getPostContentFiltered().substring(0, content.getPostContentFiltered().length()-1));
            }
        }

        return JsonUtils.getJson(blogContents);
    }

    /**
     * 修改文章页面返回数据
     * @param id
     * @return
     */
    @PostMapping("/edit/{id}")
    public String editContent(@PathVariable("id") int id){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        ArrayList<BlogContent> blogContents = blogContentService.showContent(map);

        return JsonUtils.getJson(blogContents.get(0));
    }

    /**
     * 删除文章
     * @param id
     * @return
     */
    @PostMapping("/deleteContent/{id}")
    public String deleteContent(@PathVariable("id") int id){

        int i = blogContentService.deleteContent(id);
        if (i == 1){
            System.out.println("删除成功");
            return JsonUtils.getJson("ok");
        }

        return null;
    }

    /**
     * 编辑页面获取文章列表
     * @return
     */
    @GetMapping("/editShowContent")
    public String editShowContent(@Param("page") Integer page, @Param("limit") Integer limit){
        ArrayList<BlogContent> contents = blogContentService.showContent(null);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", contents.size());

        if (limit+((page-1)*limit) > contents.size()) map.put("data", contents.subList((page-1)*limit, contents.size()));
        else map.put("data", contents.subList((page-1)*limit, limit+((page-1)*limit)));

        return JsonUtils.getJson(map);
    }
}
