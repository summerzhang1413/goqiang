package com.springapp.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/9/12.
 */
@Entity
@Table(name = "users_win", schema = "", catalog = "goqiang")
public class UsersWin extends BaseDomain{
    private int id;
    private String goodsname;
    private String goodsvalue;
    private String convertdatefinal;
    private String username;
    private String usertel;
    private String figure;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "goodsname")
    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    @Basic
    @Column(name = "goodsvalue")
    public String getGoodsvalue() {
        return goodsvalue;
    }

    public void setGoodsvalue(String goodsvalue) {
        this.goodsvalue = goodsvalue;
    }

    @Basic
    @Column(name = "convertdatefinal")
    public String getConvertdatefinal() {
        return convertdatefinal;
    }

    public void setConvertdatefinal(String convertdatefinal) {
        this.convertdatefinal = convertdatefinal;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "usertel")
    public String getUsertel() {
        return usertel;
    }

    public void setUsertel(String usertel) {
        this.usertel = usertel;
    }

    @Basic
    @Column(name = "figure")
    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersWin usersWin = (UsersWin) o;

        if (id != usersWin.id) return false;
        if (convertdatefinal != null ? !convertdatefinal.equals(usersWin.convertdatefinal) : usersWin.convertdatefinal != null)
            return false;
        if (figure != null ? !figure.equals(usersWin.figure) : usersWin.figure != null) return false;
        if (goodsname != null ? !goodsname.equals(usersWin.goodsname) : usersWin.goodsname != null) return false;
        if (goodsvalue != null ? !goodsvalue.equals(usersWin.goodsvalue) : usersWin.goodsvalue != null) return false;
        if (username != null ? !username.equals(usersWin.username) : usersWin.username != null) return false;
        if (usertel != null ? !usertel.equals(usersWin.usertel) : usersWin.usertel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (goodsvalue != null ? goodsvalue.hashCode() : 0);
        result = 31 * result + (convertdatefinal != null ? convertdatefinal.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (usertel != null ? usertel.hashCode() : 0);
        result = 31 * result + (figure != null ? figure.hashCode() : 0);
        return result;
    }
}
