package com.ekip.KVMK.beans;

public class userRequest {
    Long id;
    String name;
    Integer num;
    Long cityId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public userRequest(Long id) {
        this.id = id;
    }
    public userRequest()
    {

    }

}
