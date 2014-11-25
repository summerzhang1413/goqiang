package com.springapp.domain;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Administrator on 2014/8/31.
 */
@Entity
@Table(name = "user")
public class User extends BaseDomain{
    private int id;
    private String name;
    private String pwd;
    private String tel;
    private int grade;
    private Date dateRegister;
    private Date dateQiang;
    private Date datePrize;
    private Integer numQiang;
    private Integer numPrize;
    private String address;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "grade")
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "date_register")
    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    @Basic
    @Column(name = "date_qiang")
    public Date getDateQiang() {
        return dateQiang;
    }

    public void setDateQiang(Date dateQiang) {
        this.dateQiang = dateQiang;
    }

    @Basic
    @Column(name = "date_prize")
    public Date getDatePrize() {
        return datePrize;
    }

    public void setDatePrize(Date datePrize) {
        this.datePrize = datePrize;
    }

    @Basic
    @Column(name = "num_qiang")
    public Integer getNumQiang() {
        return numQiang;
    }

    public void setNumQiang(Integer numQiang) {
        this.numQiang = numQiang;
    }

    @Basic
    @Column(name = "num_prize")
    public Integer getNumPrize() {
        return numPrize;
    }

    public void setNumPrize(Integer numPrize) {
        this.numPrize = numPrize;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (grade != user.grade) return false;
        if (id != user.id) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (datePrize != null ? !datePrize.equals(user.datePrize) : user.datePrize != null) return false;
        if (dateQiang != null ? !dateQiang.equals(user.dateQiang) : user.dateQiang != null) return false;
        if (dateRegister != null ? !dateRegister.equals(user.dateRegister) : user.dateRegister != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (numPrize != null ? !numPrize.equals(user.numPrize) : user.numPrize != null) return false;
        if (numQiang != null ? !numQiang.equals(user.numQiang) : user.numQiang != null) return false;
        if (pwd != null ? !pwd.equals(user.pwd) : user.pwd != null) return false;
        if (tel != null ? !tel.equals(user.tel) : user.tel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + grade;
        result = 31 * result + (dateRegister != null ? dateRegister.hashCode() : 0);
        result = 31 * result + (dateQiang != null ? dateQiang.hashCode() : 0);
        result = 31 * result + (datePrize != null ? datePrize.hashCode() : 0);
        result = 31 * result + (numQiang != null ? numQiang.hashCode() : 0);
        result = 31 * result + (numPrize != null ? numPrize.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
