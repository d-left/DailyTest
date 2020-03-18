package cn.pzh.hl.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
//SM MyBatis通用Mapper4 S2
/**
 * 给要操作的数据库表  新建实体类
 * @Data 不需要写set,get,tostring....等方法
 * @Table 指定这个实体类和数据库中哪个 表绑定
 * 给每个字段写上注释 ，避免去数据库找 注释
 */
@Data
@Table(name = "tb_user")
public class User {
    @Id
    /*//hl 是不是表示 使用@KeySql(useGeneratedKeys = true）标记的字段，是自动生成的。
   向数据库插入数据时，不给id属性赋值，数据插入成功后，会将插入数据的主键值返回给成员变量id
   这里使用的是 JDBC方式获取主键
    * */
    @KeySql(useGeneratedKeys = true)// 使用 JDBC 方式获取主键
    private Long id;//long类型

    private String username;// 用户名

    private String password;// 密码

    private String name;// 姓名

    private Integer age;// 年龄

    //为什么要使用这个类型而不用String????
    private Integer sex;// 性别：1 男 2女

    private String phone;

    private Date createTime;// 创建时间

    private Date updateTime;// 更新时间

    private String note;// 备注
}
