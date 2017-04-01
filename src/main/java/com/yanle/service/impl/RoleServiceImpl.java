package com.yanle.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.yanle.entity.PageInfo;
import com.yanle.entity.Role;
import com.yanle.mapper.RoleMapper;
import com.yanle.mapper.UserRoleMapper;
import com.yanle.service.IRoleService;
import com.yanle.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * UserService的实现类
 *
 * @author yanle
 * @create 2017-02-18 10:37
 **/
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void selectDataGrid(PageInfo pageInfo) {
        Page<Role> page = new Page<Role>(pageInfo.getNowpage(),pageInfo.getSize());
        List<Role> list = roleMapper.selectRoleList(page,pageInfo.getSort(),pageInfo.getOrder());
        pageInfo.setRows(list);
        pageInfo.setTotal(page.getTotal());
    }

    @Override
    public Object selectTree() {
        return null;
    }

    @Override
    public List<Long> selectResourceIdListByRoleId(Long id) {
        return null;
    }

    @Override
    public void updateRoleResource(Long id, String resourceIds) {

    }

    @Override
    public Map<String, Set<String>> selectResourceMapByUserId(Long userId) {
        Map<String,Set<String>> resourceMap = new HashMap<String,Set<String>>();
        List<Long> roleIdList = userRoleMapper.selectRoleIdListByUserId(userId);
        Set<String> urlSet = new HashSet<String>();
        Set<String> roles = new HashSet<String>();
        for (Long roleId:roleIdList){
            List<Map<Long,String>> resourceList = roleMapper.selectResourceListByRoleId(roleId);
            if(null != resourceList){
                for (Map<Long,String> map:resourceList){
                    if (StringUtils.isNotBlank(map.get("url"))){
                        urlSet.add(map.get("url"));
                    }
                }
            }
            Role role = roleMapper.selectById(roleId);
            if (null != role){
                roles.add(role.getName());
            }
        }
        resourceMap.put("urls",urlSet);
        resourceMap.put("roles",roles);
        return resourceMap;
    }
}
