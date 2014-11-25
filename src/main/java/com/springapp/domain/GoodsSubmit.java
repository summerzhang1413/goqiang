package com.springapp.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/9/10.
 */
@Entity
@Table(name = "goods_submit", schema = "", catalog = "goqiang")
public class GoodsSubmit extends BaseDomain {
    private int id;
    private String name;
    private String value;
    private String number;
    private String datefinal;
    private String datesubmit;
    private String username;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
    @Column(name = "datefinal")
    public String getDatefinal() {
        return datefinal;
    }

    public void setDatefinal(String datefinal) {
        this.datefinal = datefinal;
    }

    @Basic
    @Column(name = "datesubmit")
    public String getDatesubmit() {
        return datesubmit;
    }

    public void setDatesubmit(String datesubmit) {
        this.datesubmit = datesubmit;
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

        GoodsSubmit that = (GoodsSubmit) o;

        if (id != that.id) return false;
        if (datefinal != null ? !datefinal.equals(that.datefinal) : that.datefinal != null) return false;
        if (datesubmit != null ? !datesubmit.equals(that.datesubmit) : that.datesubmit != null) return false;
        if (figure != null ? !figure.equals(that.figure) : that.figure != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (datefinal != null ? datefinal.hashCode() : 0);
        result = 31 * result + (datesubmit != null ? datesubmit.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (figure != null ? figure.hashCode() : 0);
        return result;
    }
}
