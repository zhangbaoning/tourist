package me.baoning.tourist.model;


import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 景区信息以及景区图片信息的结合类
 * @author qyn
 *
 */
@Entity
@Table(name = "view_spot")
public class ViewSpot {

    /**
     * 景区编号
     */
    private Integer vid;

    /**
     * 景区名称
     */
    private String vname;

    /**
     * 景区内容路径
     */
    private String present;

    /**
     * 景区图片跟目录
     */
    private String veiwphoto;


    /**
     * 无参构造器
     */
    public ViewSpot() {
        super();
    }


    /**
     * 不带主键的构造器
     *
     * @param vname
     * @param present
     * @param veiwphoto
     */
    public ViewSpot(String vname, String present, String veiwphoto) {
        super();
        this.vname = vname;
        this.present = present;
        this.veiwphoto = veiwphoto;
    }


    /**
     * 全参数构造器
     * @param vid
     * @param vname
     * @param present
     * @param veiwphoto
     */
    public ViewSpot(Integer vid, String vname, String present,
                    String veiwphoto) {
        super();
        this.vid = vid;
        this.vname = vname;
        this.present = present;
        this.veiwphoto = veiwphoto;
    }


    /**
     * getter和setter方法
     * @return
     */
    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getVeiwphoto() {
        return veiwphoto;
    }

    public void setVeiwphoto(String veiwphoto) {
        this.veiwphoto = veiwphoto;
    }


    /**
     * 重写toString(),equals(),hashCode()方法
     * @return
     */
    @Override
    public String toString() {
        return "VeiwSpot [present=" + present + ", vid=" + vid + ", viewphoto="
                + veiwphoto + ", vname=" + vname + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vid == null) ? 0 : vid.hashCode());
        return result;
    }




}
