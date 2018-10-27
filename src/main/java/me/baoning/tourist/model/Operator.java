package me.baoning.tourist.model;

import java.io.Serializable;

/**
 * 管理员类，用于封装数据库管理员对象
 * @author qyn
 * 
 */
public class Operator implements Serializable{
	/**管理员id*/
	private Integer opid;
	/**管理员账号*/
	private String opname;
	/**管理员密码*/
	private String oppwd;
	/**无参构造器*/
	public Operator() {
		super();
	}
	/**除去id属性的构造器*/
	public Operator(String opname, String oppwd) {
		super();
		this.opname = opname;
		this.oppwd = oppwd;
	}
	/**全参构造器*/
	public Operator(Integer opid, String opname, String oppwd) {
		super();
		this.opid = opid;
		this.opname = opname;
		this.oppwd = oppwd;
	}
	
	/**getter和setter方法*/
	public Integer getOpid() {
		return opid;
	}
	public void setOpid(Integer opid) {
		this.opid = opid;
	}
	public String getOpname() {
		return opname;
	}
	public void setOpname(String opname) {
		this.opname = opname;
	}
	public String getOppwd() {
		return oppwd;
	}
	public void setOppwd(String oppwd) {
		this.oppwd = oppwd;
	}
	
	/**重写toString()*/
	@Override
	public String toString() {
		return "Operator [opid=" + opid + ", opname=" + opname + ", oppwd="
				+ oppwd + "]";
	}
	
	/**重写hashCode() equals() */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opid == null) ? 0 : opid.hashCode());
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
		com.tarena.entity.Operator other = (com.tarena.entity.Operator) obj;
		if (opid == null) {
			if (other.opid != null)
				return false;
		} else if (!opid.equals(other.opid))
			return false;
		return true;
	}
	
	
}
