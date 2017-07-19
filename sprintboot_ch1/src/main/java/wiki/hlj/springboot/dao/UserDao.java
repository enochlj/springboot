package wiki.hlj.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 操作用户信息的Dao
 * Created by HLJ on 2017/7/19 10:30.
 */
@Repository("userDao")
public class UserDao {

    // **JdbcTemplate文档https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    // **Spring的JdbcTemplate是自动配置的，可以直接使用@Autowired来注入到自己的bean中来使用
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Description: 保存用户
     * @author HLJ
     * @date 2017/7/19 10:38
     * @param name 名字
     * @param age 年龄
     */
    public void save(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO user (name, age) VALUES (?, ?)", name, age);
    }

    /**
     * Description: 根据名字删除用户
     * @author HLJ
     * @date 2017/7/19 10:39
     * @param name 名字
     */
    public void removeByName(String name) {
        jdbcTemplate.update("DELETE FROM user WHERE name = ?", name);
    }

    /**
     * Description: 获取用户数量
     * @author HLJ
     * @date 2017/7/19 10:39
     * @return  用户数量
     */
    public Integer getUserCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", Integer.class);
    }

    /**
     * Description: 删除所有用户
     * @author HLJ
     * @date 2017/7/19 10:40
     */
    public void removeAllUsers() {
        jdbcTemplate.update("DELETE FROM user");
    }


}
