package top.laotun.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.laotun.pojo.BlogContent;
import top.laotun.pojo.BlogUser;
import top.laotun.service.BlogContextService;
import top.laotun.service.BlogUserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BlogController {

    @Autowired
    @Qualifier("BlogUserServiceImpl")
    private BlogUserService blogUserService;

    @PostMapping("/login")
    public String login(@Param("login") String login, @Param("pwd") String pwd, HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("login", login);
        map.put("pwd", pwd);
        BlogUser user = blogUserService.login(map);
        ObjectMapper mapper = new ObjectMapper();

        if (user.toString() != null){
            Cookie cookie = new Cookie("user_key",user.getUserName() + "-" + "key");
            cookie.setPath("/");
            cookie.setMaxAge(60*2);
            response.addCookie(cookie);
            try {
                return mapper.writeValueAsString("ok");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Autowired
    @Qualifier("BlogContextServiceImpl")
    private BlogContextService blogContextService;

    @PostMapping("/content")
    public String showContext(){

        ArrayList<BlogContent> contents = blogContextService.showContext();

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
