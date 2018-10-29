package me.baoning.tourist.model;

/**
 * 封装游记类，游记评论数，游记简单内容的一个实体类,便于页面显示
 * @author qyn
 *
 */
public class TravelsMore implements Comparable {
	/**
	 * 发表者信息
	 */
	private User user;
	/**
	 * 游记类信息
	 */
	private Travels travels;
	/**
	 * 游记简单内容
	 */
	private String present1;
	/**
	 * 评论数
	 */
	private Integer discussNum;

	/**
	 * 无参数构造器
	 */
	public TravelsMore() {
		super();
	}

	/**
	 * 全参数构造器
	 *
	 * @param user
	 * @param travels
	 * @param present1
	 * @param discussNum
	 */
	public TravelsMore(User user, Travels travels, String present1,
					   Integer discussNum) {
		super();
		this.user = user;
		this.travels = travels;
		this.present1 = present1;
		this.discussNum = discussNum;
	}


	/**
	 * 重写toString.equals.hasCode方法
	 *
	 * @return
	 */
	@Override
	public String toString() {
		return "TravelsMore [discussNum=" + discussNum + ", present1="
				+ present1 + ", travels=" + travels + ", user=" + user + "]";
	}

	/**
	 * getter和setter
	 *
	 * @return
	 */
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Travels getTravels() {
		return travels;
	}

	public void setTravels(Travels travels) {
		this.travels = travels;
	}

	public String getPresent1() {
		return present1;
	}

	public void setPresent1(String present1) {
		this.present1 = present1;
	}

	public Integer getDiscussNum() {
		return discussNum;
	}

	public void setDiscussNum(Integer discussNum) {
		this.discussNum = discussNum;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((discussNum == null) ? 0 : discussNum.hashCode());
		result = prime * result
				+ ((present1 == null) ? 0 : present1.hashCode());
		result = prime * result + ((travels == null) ? 0 : travels.hashCode());
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
		TravelsMore other = (TravelsMore) obj;
		if (discussNum == null) {
			if (other.discussNum != null) {
				return false;
			}
		} else if (!discussNum.equals(other.discussNum)) {
			return false;
		}
		if (present1 == null) {
			if (other.present1 != null) {
				return false;
			}
		} else if (!present1.equals(other.present1)) {
			return false;
		}
		if (travels == null) {
			if (other.travels != null) {
				return false;
			}
		} else if (!travels.equals(other.travels)) {
			return false;
		}
		if (user == null) {
			return other.user == null;
		} else {
			return user.equals(other.user);
		}
	}

	public int compareTo(Object o) {
		TravelsMore tm = (TravelsMore) o;
		return tm.discussNum;
	}

}
