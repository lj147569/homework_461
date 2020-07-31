package com.definesys.pojo;

import com.definesys.mpaas.query.annotation.SQL;
import com.definesys.mpaas.query.annotation.SQLQuery;

@SQLQuery(value = {
        @SQL(view = "find_actor",sql = "select * from find_actor")
})
public class Actor {
    private String name;
    private String pinyin;
    private String birthday;
    private String town;
    private String sex;
    private String description;
    private String avatar;
    private String moviename;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
