package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MyBatisUtils;

import java.util.List;

public class UserMapperTest {
    @Test
    public void getUsers(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> users = userDao.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    public void getUserByID(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = userDao.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void insertUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("addUser");
        user.setPwd("UserPwd");
        userDao.insertUser(user);
        List<User> users = userDao.getUsers();
        for (User user1 : users) {
            System.out.println(user1);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        userDao.delUser(7);
        List<User> users = userDao.getUsers();
        for (User user1 : users) {
            System.out.println(user1);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        User user = new User(1,"newName","newPwd");
        userDao.updateUser(user);
        System.out.println(userDao.getUserById(1));
        sqlSession.commit();
        sqlSession.close();
    }

}
