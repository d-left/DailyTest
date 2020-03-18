package cn.pzh.hl.user.service;

import cn.pzh.hl.user.mapper.UserMapper;
import cn.pzh.hl.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//SM MyBatis通用Mapper4 S5
/**
 * 新建service接口，service实现类 或者 直接 新建service实现类（不要service接口）
 * 定义service方法
 */
@Service
public class UserService {
    /**
     * hl
     * 使用通过mapper 自动 注入mapper代码，会报错，忽如它
     * alt+enter-->Inspection....options-->Disable Inspection
     *
     * mybatis会 创建 mapper接口的实现类对象
     *
     */
    @Autowired
    private UserMapper userMapper;

    public User queryUserById(Long id) {
       return userMapper.selectByPrimaryKey(id);
    }
}
