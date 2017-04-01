package com.yanle.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.yanle.entity.Resource;
import com.yanle.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *  @author yanle
 */
@Mapper
public interface RoleMapper {
    List<Map<Long,String>> selectResourceListByRoleId(Long roleId);

    Role selectById(Long roleId);

    List<Resource> selectResourceListByRoleIdList(List<Long> roleIdList);

    List<Role> selectRoleList(Pagination page, @Param("sort") String sort, @Param("order") String order);
}
