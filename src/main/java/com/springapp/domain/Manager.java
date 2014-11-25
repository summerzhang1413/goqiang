package com.springapp.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/8/25.
 */
@Entity
@Table(name = "manager")
public class Manager extends BaseDomain{
    private int mId;
    private String mName;
    private String mPwd;
    private int mLevel;

    @Id
    @Column(name = "m_id")
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    @Basic
    @Column(name = "m_name")
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    @Basic
    @Column(name = "m_pwd")
    public String getmPwd() {
        return mPwd;
    }

    public void setmPwd(String mPwd) {
        this.mPwd = mPwd;
    }

    @Basic
    @Column(name = "m_level")
    public int getmLevel() {
        return mLevel;
    }

    public void setmLevel(int mLevel) {
        this.mLevel = mLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manager manager = (Manager) o;

        if (mId != manager.mId) return false;
        if (mLevel != manager.mLevel) return false;
        if (mName != null ? !mName.equals(manager.mName) : manager.mName != null) return false;
        if (mPwd != null ? !mPwd.equals(manager.mPwd) : manager.mPwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mId;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (mPwd != null ? mPwd.hashCode() : 0);
        result = 31 * result + mLevel;
        return result;
    }
}
