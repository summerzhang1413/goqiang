package com.springapp.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2014/10/3.
 */
@Entity
@Table(name = "city", schema = "", catalog = "goqiang")
public class City extends BaseDomain {
    private int id;
    private String cityenglish;
    private String citychinese;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cityenglish")
    public String getCityenglish() {
        return cityenglish;
    }

    public void setCityenglish(String cityenglish) {
        this.cityenglish = cityenglish;
    }

    @Basic
    @Column(name = "citychinese")
    public String getCitychinese() {
        return citychinese;
    }

    public void setCitychinese(String citychinese) {
        this.citychinese = citychinese;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;
        if (citychinese != null ? !citychinese.equals(city.citychinese) : city.citychinese != null) return false;
        if (cityenglish != null ? !cityenglish.equals(city.cityenglish) : city.cityenglish != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cityenglish != null ? cityenglish.hashCode() : 0);
        result = 31 * result + (citychinese != null ? citychinese.hashCode() : 0);
        return result;
    }
}
