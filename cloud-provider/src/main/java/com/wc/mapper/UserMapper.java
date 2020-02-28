package com.wc.mapper;

import com.wc.entity.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface UserMapper extends Mapper<User>, IdsMapper<User> {
}
