package me.baoning.tourist.service;

import me.baoning.tourist.dao.UserDao;
import me.baoning.tourist.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User业务层
 * @author qyn
 * 
 */
@Service
public class UserService {

	@Autowired private UserDao userDao;
	//后台统计总个数，用于分页查询页数计算
	public Integer countUserNum() {
		Integer userNum=userDao.countUserNum();
		return userNum;
	}
	
	//查询所有用户信息
	public List<User> findAllUser() {
		List<User> userList=userDao.findAllUser();
		return userList;
	}
	
	//根据关键字模糊查找
	public List<User> mfindUser(String keywords) {
		List<User>userList=userDao.mfindUser(keywords);
		return userList;
	}
	
	//根据用户id删除
	public Integer deleteUserById(Integer userid) {
		Integer i=userDao.deleteUserById(userid);
		return i;
	}
	
	//根据用户邮箱查询
	public User findByEmail(String email) {
		User user=userDao.findByEmail(email);
		return user;
	}
	
	//根据用户昵称查询
	public User findByNickname(String nickname) {
		User user=userDao.findByNickname(nickname);
		return user;
	}
	
	//前台登陆操作
	public User login(String email, String userpwd) {
		User user=userDao.findByEmail(email);
		System.out.println(user);
		if(user==null||!userpwd.equals(user.getUserpwd())){
			return null;
		}
		return user;
	}
	
	//前台注册操作
	public Integer addUser(String email, String userpwd, String nickname) {
		User user=new User(email, userpwd, nickname);
		Integer i=userDao.addUser(user);
		return i;
	}
	
	//根据uid查找用户信息
	public User findByUid(Integer uid) {
		User user=userDao.findByUid(uid);
		return user;
	}
	
	//更新用户信息 
	public Integer updateUser(User user) {
		Integer i =userDao.updateUser(user);
		return i;
	}
}
