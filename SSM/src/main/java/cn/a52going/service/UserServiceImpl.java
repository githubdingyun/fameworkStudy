package cn.a52going.service;


import cn.a52going.dao.UserMapper;
import cn.a52going.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@ClassName: UserServiceImpl
 *@description: 类描述
 *@author: wangjunhui@wondersgroup.com
 *@data: 2018/5/11 14:43
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getAll() {
        return userMapper.getAll();
    }
}
