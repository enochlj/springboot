package wiki.hlj.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiki.hlj.springboot.dao.UserDao;

/**
 * 用户信息的Service
 * Created by HLJ on 2017/7/19 10:41.
 */
@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * Description: 保存用户
     * @author HLJ
     * @date 2017/7/19 10:38
     * @param name 名字
     * @param age 年龄
     */
    public void save(String name, Integer age) {
        userDao.save(name, age);
    }

    /**
     * Description: 根据名字删除用户
     * @author HLJ
     * @date 2017/7/19 10:39
     * @param name 名字
     */
    public void removeByName(String name) {
        userDao.removeByName(name);
    }

    /**
     * Description: 获取用户数量
     * @author HLJ
     * @date 2017/7/19 10:39
     * @return  用户数量
     */
    public Integer getUserCount() {
        return userDao.getUserCount();
    }

    /**
     * Description: 删除所有用户
     * @author HLJ
     * @date 2017/7/19 10:40
     */
    public void removeAllUsers() {
        userDao.removeAllUsers();
    }
}
