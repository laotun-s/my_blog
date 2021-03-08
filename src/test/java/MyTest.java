import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.laotun.mapper.BlogUserMapper;
import top.laotun.pojo.BlogUser;


import java.util.HashMap;
import java.util.Map;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlogUserMapper blogUserMapper = context.getBean("blogUserMapper", BlogUserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("login", "laotun");
        map.put("pwd", "123456");
        BlogUser laotun = blogUserMapper.login(map);
        System.out.println(laotun);
    }
}
