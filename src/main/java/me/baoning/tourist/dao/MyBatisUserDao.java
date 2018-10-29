package me.baoning.tourist.dao;

import me.baoning.tourist.model.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * User用户CRUD灵活性接口的实现类
 * @author qyn
 * 
 */
@Repository("userDao")
public class MyBatisUserDao implements UserDao{
	/**注入SqlSessionTemplate用于调用CRUD*/
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;


	/**
	 * 查询所有用户信息
	 *
	 * @return
	 */
	@Override
	public List<User> findAllUser() {
		return sqlSessionTemplate.selectList("findAllUser");
	}


	/**
	 * 统计用户数量，用于页数计算
	 * @return
	 */
	@Override
	public Integer countUserNum() {
		return sqlSessionTemplate.selectOne("countUserNum");
	}


	/**
	 * 根据关键字查找满足条件的用户
	 * @param keywords
	 * @return
	 */
	@Override
	public List<User> mfindUser(String keywords) {
		return sqlSessionTemplate.selectList("mfindUser", keywords);
	}


	/**
	 * 根据用户id删除
	 * @param userid
	 * @return
	 */
	@Override
	public Integer deleteUserById(Integer userid) {
		return sqlSessionTemplate.delete("deleteUserById", userid);
	}


	/**
	 * 根据用户邮箱查询
	 * @param email
	 * @return
	 */
	@Override
	public User findByEmail(String email) {
		return sqlSessionTemplate.selectOne("findByEmail", email);
	}


	/**
	 * 根据用户昵称查询
	 * @param nickname
	 * @return
	 */
	@Override
	public User findByNickname(String nickname) {
		return sqlSessionTemplate.selectOne("findByNickname", nickname);
	}


	/**
	 * 前台注册
	 * @param user
	 * @return
	 */
	@Override
	public Integer addUser(User user) {
		return sqlSessionTemplate.insert("addUser", user);
	}


	/**
	 * 根据用户编号查询用户
	 * @param uid
	 * @return
	 */
	@Override
	public User findByUid(Integer uid) {
		return sqlSessionTemplate.selectOne("findByUid", uid);
	}


	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	@Override
	public Integer updateUser(User user) {
		return sqlSessionTemplate.update("updateUser",user)
		;
	}
}
