package com.springapp.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/10/9.
 */
@Entity
@Table(name = "open_win", schema = "", catalog = "goqiang")
public class OpenWin extends BaseDomain{
    private int id;
    private String datefinal;
    private String figure;
    private String personnumber;
    private String goodsname;
    private String goodsnumber;
    private String price;
    private String userswin;
    private String city;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datefinal")
    public String getDatefinal() {
        return datefinal;
    }

    public void setDatefinal(String datefinal) {
        this.datefinal = datefinal;
    }

    @Basic
    @Column(name = "figure")
    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }

    @Basic
    @Column(name = "personnumber")
    public String getPersonnumber() {
        return personnumber;
    }

    public void setPersonnumber(String personnumber) {
        this.personnumber = personnumber;
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
    @Column(name = "goodsnumber")
    public String getGoodsnumber() {
        return goodsnumber;
    }

    public void setGoodsnumber(String goodsnumber) {
        this.goodsnumber = goodsnumber;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "userswin")
    public String getUserswin() {
        return userswin;
    }

    public void setUserswin(String userswin) {
        this.userswin = userswin;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpenWin openWin = (OpenWin) o;

        if (id != openWin.id) return false;
        if (city != null ? !city.equals(openWin.city) : openWin.city != null) return false;
        if (datefinal != null ? !datefinal.equals(openWin.datefinal) : openWin.datefinal != null) return false;
        if (figure != null ? !figure.equals(openWin.figure) : openWin.figure != null) return false;
        if (goodsname != null ? !goodsname.equals(openWin.goodsname) : openWin.goodsname != null) return false;
        if (goodsnumber != null ? !goodsnumber.equals(openWin.goodsnumber) : openWin.goodsnumber != null) return false;
        if (personnumber != null ? !personnumber.equals(openWin.personnumber) : openWin.personnumber != null)
            return false;
        if (price != null ? !price.equals(openWin.price) : openWin.price != null) return false;
        if (userswin != null ? !userswin.equals(openWin.userswin) : openWin.userswin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datefinal != null ? datefinal.hashCode() : 0);
        result = 31 * result + (figure != null ? figure.hashCode() : 0);
        result = 31 * result + (personnumber != null ? personnumber.hashCode() : 0);
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (goodsnumber != null ? goodsnumber.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (userswin != null ? userswin.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
