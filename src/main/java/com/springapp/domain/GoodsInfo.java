package com.springapp.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/10/2.
 */
@Entity
@Table(name = "goods_info", schema = "", catalog = "goqiang")
public class GoodsInfo extends BaseDomain {
    private int id;
    private String imagename;
    private String goodsname;
    private String price;
    private String number;
    private String detail;
    private String datefinal;
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
    @Column(name = "imagename")
    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
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
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "number")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Basic
    @Column(name = "datefinal")
    public String getDatefinal() {
        return datefinal;
    }

    public void setDatefinal(String datefinal) {
        this.datefinal = datefinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsInfo goodsInfo = (GoodsInfo) o;

        if (id != goodsInfo.id) return false;
        if (datefinal != null ? !datefinal.equals(goodsInfo.datefinal) : goodsInfo.datefinal != null) return false;
        if (detail != null ? !detail.equals(goodsInfo.detail) : goodsInfo.detail != null) return false;
        if (goodsname != null ? !goodsname.equals(goodsInfo.goodsname) : goodsInfo.goodsname != null) return false;
        if (imagename != null ? !imagename.equals(goodsInfo.imagename) : goodsInfo.imagename != null) return false;
        if (number != null ? !number.equals(goodsInfo.number) : goodsInfo.number != null) return false;
        if (price != null ? !price.equals(goodsInfo.price) : goodsInfo.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (imagename != null ? imagename.hashCode() : 0);
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        result = 31 * result + (datefinal != null ? datefinal.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
