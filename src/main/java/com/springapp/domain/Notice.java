package com.springapp.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/10/16.
 */
@Entity
@Table(name = "notice")
public class Notice extends BaseDomain{
    private int id;
    private String title;
    private String content;
    private String datepublish;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "datepublish")
    public String getDatepublish() {
        return datepublish;
    }

    public void setDatepublish(String datepublish) {
        this.datepublish = datepublish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notice notice = (Notice) o;

        if (id != notice.id) return false;
        if (content != null ? !content.equals(notice.content) : notice.content != null) return false;
        if (datepublish != null ? !datepublish.equals(notice.datepublish) : notice.datepublish != null) return false;
        if (title != null ? !title.equals(notice.title) : notice.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (datepublish != null ? datepublish.hashCode() : 0);
        return result;
    }
}
