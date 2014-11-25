package com.springapp.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/9/14.
 */
@Entity
@Table(name = "users_forget", schema = "", catalog = "goqiang")
public class UsersForget extends BaseDomain{
    private int id;
    private String username;
    private String usertel;
    private String flag;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersForget that = (UsersForget) o;

        if (id != that.id) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (usertel != null ? !usertel.equals(that.usertel) : that.usertel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (usertel != null ? usertel.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }
}
