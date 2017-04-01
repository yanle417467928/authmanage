package com.yanle.service;

import com.yanle.entity.PageInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lenovo on 2017-02-15.
 *
 */
public interface IRoleService {

    void selectDataGrid(PageInfo pageInfo);

    Object selectTree();

    List<Long> selectResourceIdListByRoleId(Long id);

    void updateRoleResource(Long id,String resourceIds);

    Map<String ,Set<String>> selectResourceMapByUserId(Long userId);

}
