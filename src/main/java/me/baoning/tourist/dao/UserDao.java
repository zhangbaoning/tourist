package me.baoning.tourist.dao;

import me.baoning.tourist.model.User;

import java.util.List;

/**
 * User用户类CRUD灵活性接口
 * @author qyn
 * 
 */
public interface UserDao {
	
	//查询用户数量用于分页查询页面计算
	Integer countUserNum();
	
	//查询所有用户信息
	List<User> findAllUser();
	
	//根据关键字查询满足条件的用户
	List<User> mfindUser(String keywords);
	
	//根据用户id删除
	Integer deleteUserById(Integer userid);
	
	//根据用户邮箱查询
	User findByEmail(String email);
	
	//根据用户昵称查询
	User findByNickname(String nickname);
	
	//前台注册
	Integer addUser(User user);
	
	//根据用户id查找用户信息
	User findByUid(Integer uid);
	
	//更新用户信息
	Integer updateUser(User user);
}
