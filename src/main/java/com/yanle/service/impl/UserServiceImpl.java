package com.yanle.service.impl;

import com.yanle.entity.PageInfo;
import com.yanle.entity.User;
import com.yanle.entity.UserVo;
import com.yanle.mapper.UserMapper;
import com.yanle.mapper.UserRoleMapper;
import com.yanle.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService的实现类
 *
 * @author yanle
 * @create 2017-02-18 10:37
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public List<User> selectByLoginName(UserVo userVo) {
        List<User> userList = userMapper.selectByLoginName(userVo);
        return userList;
    }

    @Override
    public void insertByVo(UserVo userVo) {

    }

    @Override
    public UserVo selectVoById(Long id) {
        return null;
    }

    @Override
    public void updateByVo(UserVo userVo) {

    }

    @Override
    public void updatePwdByUserId(Long userId, String md5Hex) {

    }

    @Override
    public void selectDataGrid(PageInfo pageInfo) {

    }

    @Override
    public void deleteUserById(Long id) {

    }
}
