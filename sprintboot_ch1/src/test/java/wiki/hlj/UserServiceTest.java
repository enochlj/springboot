package wiki.hlj;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiki.hlj.springboot.service.UserService;

/**
 * UserService的测试类
 * Created by HLJ on 2017/7/19 10:45.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void clearDb() {
        // 准备，清空user表
        userService.removeAllUsers();
    }

    @Test
    public void test(){
        // 插入5个用户
        userService.save("a", 1);
        userService.save("b", 2);
        userService.save("c", 3);
        userService.save("d", 4);
        userService.save("e", 5);
        // 查数据库，应该有5个用户
        Assert.assertEquals(5, userService.getUserCount().intValue());
        // 删除两个用户
        userService.removeByName("a");
        userService.removeByName("e");
        // 查数据库，removeByName
        Assert.assertEquals(3, userService.getUserCount().intValue());
    }


}
