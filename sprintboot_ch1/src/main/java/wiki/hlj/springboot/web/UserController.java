package wiki.hlj.springboot.web;

import org.springframework.web.bind.annotation.*;
import wiki.hlj.springboot.domain.User;

import java.util.*;

/**
 * 用户服务
 * Created by HLJ on 2017/7/4 18:41.
 */
@RestController
@RequestMapping("/users")// 通过这里配置使下面的映射都在/users下
public class UserController {

    // 创建线程安全的Map
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    /**
     * 保存用户信息
     * @param user 用户信息实体类
     * @return 保存结果
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        users.put(user.getId(), user);
        return "SUCCESS";
    }

    /**
     * 删除用户信息
     * @param id 用户ID
     * @return 删除结果
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String removeUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "SUCCESS";
    }

    /**
     * 更新用户信息
     * @param id 用户ID
     * @param user 用户信息的实体类
     * @return 更新结果
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        if (u == null) {
            return "FAILURE";
        }

        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "SUCCESS";
    }

    /**
     * 查询用户信息
     * @param id 用户ID
     * @return User
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    /**
     * 获取用户列表
     * @return List<User>
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> listUser() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        return new ArrayList<>(users.values());
    }

}
