package dao;

import pojo.User;

import java.util.List;

public interface UserMapper {
    //查询所有用户
    List<User> getUsers();
    //根据id查询用户
    User getUserById(int id);
    //插入一个用户
    int insertUser(User user);
    //根据id删除用户
    int delUser(int id);
    //修改用户信息
    int updateUser(User user);
}
