package top.laotun.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.laotun.Utils.JsonUtils;
import top.laotun.pojo.BlogUser;
import top.laotun.service.BlogUserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class BlogUserController {

    @Autowired
    @Qualifier("BlogUserServiceImpl")
    private BlogUserService blogUserService;

    /**
     * 登陆处理
     * @param login
     * @param pwd
     * @param response
     * @return
     */
    @PostMapping("/login")
    public String login(@Param("login") String login, @Param("pwd") String pwd, HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("login", login);
        map.put("pwd", pwd);
        BlogUser user = blogUserService.login(map);

        if (user.toString() != null){
            Cookie cookie = new Cookie("user_key",user.getUserName() + "-" + "key");
            cookie.setPath("/");
            cookie.setMaxAge(60*2);
            response.addCookie(cookie);

            return JsonUtils.getJson("ok");
        }
        return null;
    }


}
