package com.yanle.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  Created by lenovo on 2017-02-18.
 */
@Mapper
public interface UserRoleMapper {

    List<Long> selectRoleIdListByUserId(@Param("userId") Long userId);
}
