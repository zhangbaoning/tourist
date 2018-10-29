package me.baoning.tourist.model;

import java.sql.Date;

/**
 * 问答实体类
 * @author qyn
 *
 */
public class Question {

	/**
	 * 问答编号
	 */
	private Integer qid;

	/**
	 * 发布者编号
	 */
	private Integer uid;

	/**
	 * 发布时间
	 */
	private Date qtime;

	/**
	 * 提问的内容
	 */
	private String present;

	/**
	 * 问题的状态
	 */
	private String state;

	/**
	 * 问答的标题
	 */
	private String qtitle;

	/**
	 * 无参数构造器
	 */
	public Question() {
		super();
	}


	/**
	 * 去问答类主键构造器
	 * @param uid
	 * @param qtime
	 * @param present
	 * @param state
	 * @param qtitle
	 */
	public Question(Integer uid, Date qtime, String present, String state,
			String qtitle) {
		super();
		this.uid = uid;
		this.qtime = qtime;
		this.present = present;
		this.state = state;
		this.qtitle = qtitle;
	}


	/**
	 * 全构造器
	 * @param qid
	 * @param uid
	 * @param qtime
	 * @param present
	 * @param state
	 * @param title
	 */
	public Question(Integer qid, Integer uid, Date qtime, String present,
			String state, String title) {
		super();
		this.qid = qid;
		this.uid = uid;
		this.qtime = qtime;
		this.present = present;
		this.state = state;
		this.qtitle = qtitle;
	}


	/**
	 * 问答类的getter和setter方法
	 * @return
	 */
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Date getQtime() {
		return qtime;
	}
	public void setQtime(Date qtime) {
		this.qtime = qtime;
	}
	public String getPresent() {
		return present;
	}
	public void setPresent(String present) {
		this.present = present;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}


	/**
	 * 重写toString()方法 equals()和hasCode()方法
	 * @return
	 */
	@Override
	public String toString() { 
		return "Question [present=" + present + ", qid=" + qid + ", qtime="
				+ qtime + ", state=" + state + ", qtitle=" + qtitle + ", uid="
				+ uid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qid == null) ? 0 : qid.hashCode());
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
		Question other = (Question) obj;
		if (qid == null) {
			if (other.qid != null) {
				return false;
			}
		} else if (!qid.equals(other.qid)) {
			return false;
		}
		return true;
	}
	
}
