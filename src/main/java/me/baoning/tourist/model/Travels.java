package me.baoning.tourist.model;

import java.sql.Date;

/**
 * 游记实体类
 * @author qyn
 *
 */
public class Travels {
	//游记编号
	private Integer tid;
	//游记发表者编号
	private Integer uid;
	//游记标题
	private String title;
	//游记发表时间
	private Date atime;
	//游记内容路径
	private String present;
	//游记图片路径
	private String travelsphoto;
	//游记状态,是否审核
	private String state;
	//无参数构造器
	public Travels() {
		super();
	}
	//游记内容路径uid构造器
	public Travels(Integer uid, String present) {
		super();
		this.uid = uid;
		this.present = present;
	}
	//游记图片路径uid构造器
	public Travels(String travelsphoto,Integer uid) {
		super();
		this.uid = uid;
		this.travelsphoto = travelsphoto;
	}
	//去游记编号构造器
	public Travels(Integer uid, String title, Date atime, String present,
			String travelsphoto, String state) {
		super();
		this.uid = uid;
		this.title = title;
		this.atime = atime;
		this.present = present;
		this.travelsphoto = travelsphoto;
		this.state = state;
	}

	//全参数构造器
	public Travels(Integer tid, Integer uid, String title, Date atime,
			String present, String travelsphoto, String state) {
		super();
		this.tid = tid;
		this.uid = uid;
		this.title = title;
		this.atime = atime;
		this.present = present;
		this.travelsphoto = travelsphoto;
		this.state = state;
	}
	//getter和setter方法
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getAtime() {
		return atime;
	}
	public void setAtime(Date atime) {
		this.atime = atime;
	}
	public String getPresent() {
		return present;
	}
	public void setPresent(String present) {
		this.present = present;
	}
	public String getTravelsphoto() {
		return travelsphoto;
	}
	public void setTravelsphoto(String travelsphoto) {
		this.travelsphoto = travelsphoto;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	//重写toString().hasCode(),equals()
	@Override
	public String toString() {
		return "Travels [atime=" + atime + ", present=" + present + ", state="
				+ state + ", tid=" + tid + ", title=" + title
				+ ", travelsphoto=" + travelsphoto + ", uid=" + uid + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		return result;
	}
	
}
