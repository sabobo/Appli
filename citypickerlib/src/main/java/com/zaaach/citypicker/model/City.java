package com.zaaach.citypicker.model;

/**
 * author zaaach on 2016/1/26.
 */
public class City {
    private String name;
    private String pinyin;
    private String city_id;
    public City() {}

    public City(String name, String pinyin, String city_id) {
        this.name = name;
        this.pinyin = pinyin;
        this.city_id = city_id;
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

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }
}
