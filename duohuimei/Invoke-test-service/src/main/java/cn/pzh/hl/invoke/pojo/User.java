package cn.pzh.hl.invoke.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
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
