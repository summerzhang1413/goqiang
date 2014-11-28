package com.springapp.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/11/28.
 */
@Entity
@Table(name = "couriers", schema = "", catalog = "goqiang")
public class Couriers extends BaseDomain {
    private int id;
    private String courier;
    private String pwd;
    private String tel;
    private String name;
    private String studentid;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "courier")
    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    @Basic
    @Column(name = "pwd")
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "studentid")
    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Couriers couriers = (Couriers) o;

        if (id != couriers.id) return false;
        if (courier != null ? !courier.equals(couriers.courier) : couriers.courier != null) return false;
        if (name != null ? !name.equals(couriers.name) : couriers.name != null) return false;
        if (pwd != null ? !pwd.equals(couriers.pwd) : couriers.pwd != null) return false;
        if (studentid != null ? !studentid.equals(couriers.studentid) : couriers.studentid != null) return false;
        if (tel != null ? !tel.equals(couriers.tel) : couriers.tel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (courier != null ? courier.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (studentid != null ? studentid.hashCode() : 0);
        return result;
    }
}
