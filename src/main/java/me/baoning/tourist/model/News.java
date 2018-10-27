package me.baoning.tourist.model;

import java.sql.Date;

/**
 * 新闻实体类
 * @author qyn
 *
 */
public class News {
	//新闻编号
	private Integer nid;
	//新闻标题
	private String ntitle;
	//发布时间
	private Date stime;
	//新闻概述
	private String summary;
	//新闻内容路径
	private String present;
	//新闻来源
	private String quarry;
	//图片路径
	private String newphoto;
	//无参数构造器
	public News() {
		super();
	}
	//去主键构造器
	public News(String ntitle, Date stime, String summary, String present,
			String quarry, String newphoto) {
		super();
		this.ntitle = ntitle;
		this.stime = stime;
		this.summary = summary;
		this.present = present;
		this.quarry = quarry;
		this.newphoto = newphoto;
	}
	//全参数构造器
	public News(Integer nid, String ntitle, Date stime, String summary,
			String present, String quarry, String newphoto) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.stime = stime;
		this.summary = summary;
		this.present = present;
		this.quarry = quarry;
		this.newphoto = newphoto;
	}
	//编号和概述构造器
	public News(Integer nid, String summary) {
		super();
		this.nid = nid;
		this.summary = summary;
	}
	//setter和getter方法
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPresent() {
		return present;
	}
	public void setPresent(String present) {
		this.present = present;
	}
	public String getQuarry() {
		return quarry;
	}
	public void setQuarry(String quarry) {
		this.quarry = quarry;
	}
	public String getNewphoto() {
		return newphoto;
	}
	public void setNewphoto(String newphoto) {
		this.newphoto = newphoto;
	}
	//重写toString(),equals(),hashCode()方法
	@Override
	public String toString() {
		return "News [newphoto=" + newphoto + ", nid=" + nid + ", ntitle="
				+ ntitle + ", present=" + present + ", quarry=" + quarry
				+ ", stime=" + stime + ", summary=" + summary + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nid == null) ? 0 : nid.hashCode());
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
		com.tarena.entity.News other = (com.tarena.entity.News) obj;
		if (nid == null) {
			if (other.nid != null)
				return false;
		} else if (!nid.equals(other.nid))
			return false;
		return true;
	}
	
}
