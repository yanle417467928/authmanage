package com.yanle.mapper;

import com.yanle.entity.User;
import com.yanle.entity.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Created by lenovo on 2017-02-18.
 */
@Mapper
public interface UserMapper {
    UserVo selectUserVoById(@Param("id") Long id);

    List<User> selectByLoginName(UserVo userVo);
}
