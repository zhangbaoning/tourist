package me.baoning.tourist.model;

import java.io.Serializable;

/**
 * 网站用户实体类
 * @author qyn
 * 
 */
public class User implements Serializable{
	//用户编号userid
	private	 Integer userid;
	//用户邮箱email
	private String email;
	//用户密码userpwd
	private String userpwd;
	/**
	 * 以下为待完整的用户信息，在注册时不需要具体填写
	 */
	//用户简介
	private String resume;
	//用户昵称
	private String nickname;
	//用户头像相对路径
	private String faceimg;
	//用户性别
	private String sex;
	//用户爱好
	private String hobby;
	
	//无参构造器
	public User() {
		super();
	}
	
	//不带主键必填信息构造器
	public User(String email, String userpwd, String nickname) {
		super();
		this.email = email;
		this.userpwd = userpwd;
		this.nickname = nickname;
	}

	//必填信息构造器
	public User(Integer userid, String email, String userpwd,String nickname) {
		super();
		this.userid = userid;
		this.email = email;
		this.userpwd = userpwd;
		this.nickname = nickname;
	}

	//不带主键构造器
	public User(String email, String userpwd, String resume, String nickname,
			String faceimg, String sex, String hobby) {
		super();
		this.email = email;
		this.userpwd = userpwd;
		this.resume = resume;
		this.nickname = nickname;
		this.faceimg = faceimg;
		this.sex = sex;
		this.hobby = hobby;
	}
	
	//全构造器
	public User(Integer userid, String email, String userpwd, String resume,
			String nickname, String faceimg, String sex, String hobby) {
		super();
		this.userid = userid;
		this.email = email;
		this.userpwd = userpwd;
		this.resume = resume;
		this.nickname = nickname;
		this.faceimg = faceimg;
		this.sex = sex;
		this.hobby = hobby;
	}
	
	//getter和setter方法
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFaceimg() {
		return faceimg;
	}

	public void setFaceimg(String faceimg) {
		this.faceimg = faceimg;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	//重写toString()
	@Override
	public String toString() {
		return "User [email=" + email + ", faceimg=" + faceimg + ", hobby="
				+ hobby + ", nickname=" + nickname + ", resume=" + resume
				+ ", sex=" + sex + ", userid=" + userid + ", userpwd="
				+ userpwd + "]";
	}
	
	//重写hashCode()和equals()方法
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userid == null) ? 0 : userid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		com.tarena.entity.User other = (com.tarena.entity.User) obj;
		if (userid == null) {
			if (other.userid != null)
				return false;
		} else if (!userid.equals(other.userid))
			return false;
		return true;
	}
}
