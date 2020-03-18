package cn.pzh.hl.user.mapper;

import cn.pzh.hl.user.pojo.User;
import tk.mybatis.mapper.common.Mapper;
//SM MyBatis通用Mapper4 S3
/**
 * 对要操作的表   新建mapper接口
 * 这个接口要继承 “通用mapper”的Mapper接口
 * “通用mapper”的Mapper接口定义好了  数据库的增、删、改、查等一系列方法----》我们不需要自己定义
 */
public interface UserMapper extends Mapper<User> {
}
