package top.laotun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import top.laotun.pojo.BlogContent;
import top.laotun.service.BlogContentService;

import java.util.ArrayList;

public class BlogContenController {
    @Autowired
    @Qualifier("BlogContentServiceImpl")
    private BlogContentService blogContentService;

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

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(contents);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
