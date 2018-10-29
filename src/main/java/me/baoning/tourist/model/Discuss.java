package me.baoning.tourist.model;

import java.sql.Date;

/**
 * 评论实体类
 *
 * @author qyn
 */
public class Discuss {
    /**
     * 评论实体类的编号
     */
    private Integer id;

    /**
     * 评论的类型
     */
    private Integer type;

    /**
     * 评论贴ID
     */
    private Integer pid;

    /**
     * 评论人ID
     */
    private Integer uid;

    /**
     * 评论时间
     */
    private Date ptime;
    /**
     * 评论的内容
     */

    private String present;

    /**
     * 无参数构造器
     */

    public Discuss() {
        super();
    }

    /**
     * 去除主键操作器
     */

    public Discuss(Integer type, Integer pid, Integer uid, Date ptime,
                   String present) {
        super();
        this.type = type;
        this.pid = pid;
        this.uid = uid;
        this.ptime = ptime;
        this.present = present;
    }

    /**
     * 全参数构造器
     */

    public Discuss(Integer id, Integer type, Integer pid, Integer uid,
                   Date ptime, String present) {
        super();
        this.id = id;
        this.type = type;
        this.pid = pid;
        this.uid = uid;
        this.ptime = ptime;
        this.present = present;
    }

    /**
     * 各属性getter和setter方法
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    /**
     * 重写toString，equals，hasCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Discuss other = (Discuss) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Discuss [id=" + id + ", pid=" + pid + ", present=" + present
                + ", ptime=" + ptime + ", type=" + type + ", uid=" + uid + "]";
    }


}
