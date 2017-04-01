package com.yanle.service;

import com.yanle.entity.PageInfo;
import com.yanle.entity.User;
import com.yanle.entity.UserVo;

import java.util.List;

/**
 * user表数据服务层接口
 */
public interface IUserService {
    List<User> selectByLoginName(UserVo userVo);
    void insertByVo(UserVo userVo);
    UserVo selectVoById(Long id);
    void updateByVo(UserVo userVo);
    void updatePwdByUserId(Long userId,String md5Hex);
    void selectDataGrid(PageInfo pageInfo);
    void deleteUserById(Long id);
}
