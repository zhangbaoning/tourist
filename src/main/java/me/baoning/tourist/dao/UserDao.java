package me.baoning.tourist.dao;

import me.baoning.tourist.model.User;

import java.util.List;

/**
 * User用户类CRUD灵活性接口
 * @author qyn
 * 
 */
public interface UserDao {


    /**
     * 查询用户数量用于分页查询页面计算
     *
     * @return
     */
	Integer countUserNum();


    /**
     * 查询所有用户信息
     * @return
	 */
	List<User> findAllUser();


    /**
     * 根据关键字查询满足条件的用户
     * @param keywords
     * @return
	 */
	List<User> mfindUser(String keywords);


    /**
     * 根据用户id删除
     * @param userid
     * @return
	 */
	Integer deleteUserById(Integer userid);


    /**
     * 根据用户邮箱查询
     * @param email
     * @return
	 */
	User findByEmail(String email);


    /**
     * 根据用户昵称查询
     * @param nickname
     * @return
	 */
	User findByNickname(String nickname);


    /**
     * 前台注册
     * @param user
     * @return
	 */
	Integer addUser(User user);


    /**
     * 根据用户id查找用户信息
     * @param uid
     * @return
	 */
	User findByUid(Integer uid);


    /**
     * 更新用户信息
     * @param user
     * @return
	 */
	Integer updateUser(User user);
}
