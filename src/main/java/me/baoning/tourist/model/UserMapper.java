package me.baoning.tourist.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * User用户对象CRUD
 *
 * @author qyn
 */
@Mapper
public interface UserMapper {
    //查询用户数量，用户页数计算
    Integer findUserNum();

    //查询所有用户信息
    List<User> findAllUser();

    //根据关键字查询满足条件的用户
    List<User> mfindUser(String keywords);

    //根据用户id删除
    void deleteUserById(Integer roomid);

    //根据用户邮箱查询
    User findByEmail(String email);

    //根据用户昵称查询
    User findByNickname(String nickname);

    //前台注册
    void addUser(User user);

    //根据用户id查找用户信息
    User findByUid(Integer uid);

    //更新用户信息
    void updateUser(User user);
}
