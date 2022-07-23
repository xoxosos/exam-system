package com.pglin.exam.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pglin.exam.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LinRenJie
 * @version 1.0.0
 * @ClassName UserMapper.java
 * @Description TODO
 * @createTime 2022年07月23日
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 所有的crud都编写完成了
}
