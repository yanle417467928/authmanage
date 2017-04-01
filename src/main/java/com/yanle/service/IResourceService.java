package com.yanle.service;

import com.yanle.entity.Resource;
import com.yanle.entity.ShiroUser;
import com.yanle.entity.Tree;

import java.util.List;

/**
 * Created by lenovo on 2017-02-15.
 *
 */
public interface IResourceService {

    List<Tree> selectTree(ShiroUser shiroUser);

    List<Resource> selectAll();

    Resource selectById(Long id);

    void updateSelectiveById(Resource resource);

    void deleteById(Long id);

    void insert(Resource resource);

    List<Tree> selectAllTree();
}
