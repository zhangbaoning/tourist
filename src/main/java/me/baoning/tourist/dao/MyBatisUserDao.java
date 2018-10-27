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
//注入时改名为userDao
@Repository("userDao")
public class MyBatisUserDao implements UserDao{
	/**注入SqlSessionTemplate用于调用CRUD*/
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	//查询所有用户信息
	public List<User> findAllUser() {
		return sqlSessionTemplate.selectList("findAllUser");
	}
	
	//统计用户数量，用于页数计算
	public Integer countUserNum() {
		return sqlSessionTemplate.selectOne("countUserNum");
	}
	
	//根据关键字查找满足条件的用户
	public List<User> mfindUser(String keywords) {
		return sqlSessionTemplate.selectList("mfindUser",keywords);
	}
	
	//根据用户id删除
	public Integer deleteUserById(Integer userid) {
		return sqlSessionTemplate.delete("deleteUserById",userid);
	}
	
	//根据用户邮箱查询
	public User findByEmail(String email) {
		return sqlSessionTemplate.selectOne("findByEmail",email);
	}

	//根据用户昵称查询
	public User findByNickname(String nickname) {
		return sqlSessionTemplate.selectOne("findByNickname",nickname);
	}
	
	//前台注册
	public Integer addUser(User user) {
		return sqlSessionTemplate.insert("addUser",user);
	}
	
	//根据用户编号查询用户
	public User findByUid(Integer uid) {
		return sqlSessionTemplate.selectOne("findByUid",uid);
	}
	
	//更新用户信息
	public Integer updateUser(User user) {
		return sqlSessionTemplate.update("updateUser",user)
		;
	}
}
