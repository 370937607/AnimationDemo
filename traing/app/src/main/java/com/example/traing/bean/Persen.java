package com.example.traing.bean;

import cn.bmob.v3.BmobObject;

public class Persen extends BmobObject {
    private String name;
    private String address;

    @Override
    public String toString() {
        return "Persen{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }






}
