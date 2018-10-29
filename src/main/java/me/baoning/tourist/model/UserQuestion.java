package me.baoning.tourist.model;
/**
 * 封装用户信息和用户提出的问题
 * @author qyn
 *
 */
public class UserQuestion {
    /**
     * 用户属性
     */
	private User user;
    /**
     * 问题属性
     */
	private Question question;

    /**
     * 无参数构造器
     */
	public UserQuestion() {
		super();
	}
    //

    /**
     * 全参数构造器
     *
     * @param user
     * @param question
     */
	public UserQuestion(User user, Question question) {
		super();
		this.user = user;
		this.question = question;
    }

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
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
    }

    /**
     * 重写toString.重写equals.重写hashCode方法
     * @return
	 */
	@Override
	public String toString() {
		return "UserQuestion [question=" + question + ", user=" + user + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	
	
}
