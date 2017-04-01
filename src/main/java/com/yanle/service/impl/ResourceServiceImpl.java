package com.yanle.service.impl;

import com.yanle.entity.Resource;
import com.yanle.entity.ShiroUser;
import com.yanle.entity.Tree;
import com.yanle.mapper.ResourceMapper;
import com.yanle.mapper.RoleMapper;
import com.yanle.mapper.UserRoleMapper;
import com.yanle.service.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * UserService的实现类
 *
 * @author yanle
 * @create 2017-02-18 10:37
 **/
@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleMapper roleMapper;

    private static final int RESOURCE_MENU = 0; // 菜单

    @Override
    public List<Tree> selectTree(ShiroUser shiroUser) {
        List<Tree> trees = new ArrayList<Tree>();
        //shiro中缓存的用户角色
        Set<String> roles = shiroUser.getRoles();
        if(null == roles){
            return trees;
        }
        //如果有超级管理员权限
        if(roles.contains("admin")){
            List<Resource> resourceList = this.selectByType(RESOURCE_MENU);
            if (null == resourceList){
                return trees;
            }
            for (Resource resource : resourceList){
                Tree tree = new Tree();
                tree.setId(resource.getId());
                tree.setPid(resource.getPid());
                tree.setText(resource.getName());
                tree.setIconCls(resource.getIcon());
                tree.setAttributes(resource.getUrl());
                tree.setOpenMode(resource.getOpenMode());
                trees.add(tree);
            }
            return trees;
        }
        //普通用户

        List<Long> roleIdList = userRoleMapper.selectRoleIdListByUserId(shiroUser.getId());
        if (null == roleIdList){
            return trees;
        }
        List<Resource> resourceLists = roleMapper.selectResourceListByRoleIdList(roleIdList);
        if (null == resourceLists){
            return trees;
        }
        for(Resource resource : resourceLists){
            Tree tree = new Tree();
            tree.setId(resource.getId());
            tree.setPid(resource.getPid());
            tree.setText(resource.getName());
            tree.setIconCls(resource.getIcon());
            tree.setAttributes(resource.getUrl());
            tree.setOpenMode(resource.getOpenMode());
            trees.add(tree);
        }
        return trees;
    }

    @Override
    public List<Resource> selectAll() {

        return resourceMapper.selectAll();
    }

    @Override
    public Resource selectById(Long id) {
        if (null == id){
            return null;
        }
        return resourceMapper.selectById(id);
    }

    @Override
    public void updateSelectiveById(Resource resource) {
        if (null != resource){
            Resource resourceTemp =  resourceMapper.selectById(resource.getId());
            if (null != resourceTemp){
                resourceMapper.updateResource(resource);
            }
        }
    }

    @Override
    public void deleteById(Long id) {
        if (null != id){
            resourceMapper.deleteById(id);
        }
    }

    @Override
    public void insert(Resource resource) {
        resourceMapper.insert(resource);
    }

    @Override
    public List<Tree> selectAllTree() {
        //获取所有资源tree形式展示
        List<Tree> trees = new ArrayList<Tree>();
        List<Resource> resources = this.selectByType(RESOURCE_MENU);
        if (null == resources){
            return trees;
        }
        for (Resource resource:resources){
            Tree tree= new Tree();
            tree.setId(resource.getId());
            tree.setPid(resource.getPid());
            tree.setText(resource.getName());
            tree.setIconCls(resource.getIcon());
            tree.setAttributes(resource.getUrl());
            trees.add(tree);
        }
        return trees;
    }

    public List<Resource> selectByType(Integer type){
        if(null == type ){
            return null;
        }
        return resourceMapper.selectByResourceType(type);
    }
}
