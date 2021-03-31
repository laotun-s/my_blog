package top.laotun.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
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
     * @param username
     * @param password
     * @param response
     * @return
     */
    @PostMapping("/login")
    public String login(@Param("username") String username,
                        @Param("password") String password,
                        HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("login", username);
        map.put("pwd", password);
        BlogUser user = blogUserService.login(map);

        if (user.toString() != null){
            Cookie cookie = new Cookie("user_key",user.getUserName() + "-" + "key");
            cookie.setPath("/");
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);

            return JsonUtils.getJson("ok");
        }
        return null;
    }

    @PostMapping("/logout")
    public String logout(HttpServletResponse response){
        Cookie cookie = new Cookie("user_key","");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return JsonUtils.getJson("ok");
    }

    @PostMapping("/changePassword")
    public String changePassword(@Param("old_password") String old_password,
                                 @Param("new_password") String new_password){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("login", "laotun");
        map.put("pwd", old_password);
        map.put("newpwd", new_password);
        int i = blogUserService.changePassword(map);
        if (i == 1){
            return JsonUtils.getJson("ok");
        }

        return null;
    }
}
