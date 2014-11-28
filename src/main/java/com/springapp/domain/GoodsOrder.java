package com.springapp.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/11/28.
 */
@Entity
@Table(name = "goods_order", schema = "", catalog = "goqiang")
public class GoodsOrder extends BaseDomain{
    private int id;
    private String datetime;
    private String username;
    private String tel;
    private String address;
    private String goodsname;
    private String goodsinfo;
    private String goodsprice;
    private String goodsnum;
    private String flag;
    private String courier;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "datetime")
    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
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
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
    @Column(name = "goodsinfo")
    public String getGoodsinfo() {
        return goodsinfo;
    }

    public void setGoodsinfo(String goodsinfo) {
        this.goodsinfo = goodsinfo;
    }

    @Basic
    @Column(name = "goodsprice")
    public String getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(String goodsprice) {
        this.goodsprice = goodsprice;
    }

    @Basic
    @Column(name = "goodsnum")
    public String getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(String goodsnum) {
        this.goodsnum = goodsnum;
    }

    @Basic
    @Column(name = "flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "courier")
    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsOrder that = (GoodsOrder) o;

        if (id != that.id) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (courier != null ? !courier.equals(that.courier) : that.courier != null) return false;
        if (datetime != null ? !datetime.equals(that.datetime) : that.datetime != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (goodsinfo != null ? !goodsinfo.equals(that.goodsinfo) : that.goodsinfo != null) return false;
        if (goodsname != null ? !goodsname.equals(that.goodsname) : that.goodsname != null) return false;
        if (goodsnum != null ? !goodsnum.equals(that.goodsnum) : that.goodsnum != null) return false;
        if (goodsprice != null ? !goodsprice.equals(that.goodsprice) : that.goodsprice != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (goodsname != null ? goodsname.hashCode() : 0);
        result = 31 * result + (goodsinfo != null ? goodsinfo.hashCode() : 0);
        result = 31 * result + (goodsprice != null ? goodsprice.hashCode() : 0);
        result = 31 * result + (goodsnum != null ? goodsnum.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (courier != null ? courier.hashCode() : 0);
        return result;
    }
}
