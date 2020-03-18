package cn.pzh.hl.user.controller;

import cn.pzh.hl.user.pojo.User;
import cn.pzh.hl.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    //SM MyBatis通用Mapper4 S5
    /**
     *在控制类中使用 service实现类
     */
    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public User queryUserById(@PathVariable("id")Long id){
//        try {
//           // Thread.sleep(1000);
//            //执行当前方法的tomcat的线程 休眠 4s
//            Thread.sleep(000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userService.queryUserById(id);
    }
}
