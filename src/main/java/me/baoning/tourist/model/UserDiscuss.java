package me.baoning.tourist.model;
/**	
 * 
 * 用户评论实体类，用于储存用户的评论信息
 * @author qyn
 *
 */
public class UserDiscuss {
	//
	/**
	 * 用户属性
	 */
	private User user;
	//
	/**
	 * 评论属性
	 */
	private Discuss discuss;
	//

	/**
	 * 无参数构造器
	 */
	public UserDiscuss() {
		super();
	}
	//

	/**
	 * 全参数构造器
	 *
	 * @param user
	 * @param discuss
	 */
	public UserDiscuss(User user, Discuss discuss) {
		super();
		this.user = user;
		this.discuss = discuss;
	}
	//

	/**
	 * getter和setter方法
	 * @return
	 */
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Discuss getDiscuss() {
		return discuss;
	}

	public void setDiscuss(Discuss discuss) {
		this.discuss = discuss;
	}
	//

	/**
	 * 重写toString和equals.hasCode方法
	 * @return
	 */
	@Override
	public String toString() {
		return "UserDiscuss [discuss=" + discuss + ", user=" + user + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((discuss == null) ? 0 : discuss.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		UserDiscuss other = (UserDiscuss) obj;
		if (discuss == null) {
			if (other.discuss != null) {
				return false;
			}
		} else if (!discuss.equals(other.discuss)) {
			return false;
		}
		if (user == null) {
			if (other.user != null) {
				return false;
			}
		} else if (!user.equals(other.user)) {
			return false;
		}
		return true;
	}
	
}
