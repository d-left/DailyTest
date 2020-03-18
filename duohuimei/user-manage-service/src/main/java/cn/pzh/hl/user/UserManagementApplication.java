//根据 启动类扫描的特点，把放到包中合适的位置
package cn.pzh.hl.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;
/**
*
* @author
* @since
*/ @EnableDiscoveryClient
@SpringBootApplication

//SM MyBatis通用Mapper4 S4
/**
 * 在启动类上开启接口扫描，设置好接口所在位置
 * @MapperScan是通用mapper的注解
 */
@MapperScan("cn.pzh.hl.user.mapper")


public class UserManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserManagementApplication.class);
    }
}
