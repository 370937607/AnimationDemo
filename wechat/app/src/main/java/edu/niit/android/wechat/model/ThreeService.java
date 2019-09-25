package edu.niit.android.wechat.model;

import java.io.Serializable;

// 实体类：会跟数据库中的表的字段一一对应
public class ThreeService implements Serializable {
    private int imgId;
    private String name;

    // 1. 创建无参和有参的构造方法：无参的构造给以后的框架反射使用，有参的构造函数是创建对象使用
    public ThreeService() {
    }

    public ThreeService(int imgId, String name) {
        this.imgId = imgId;
        this.name = name;
    }

    // 2. 创建get/set方法：给出属性的读、写的功能
    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 3. 创建toString()方法（可选）：为了显示方便

    @Override
    public String toString() {
        return "ThreeService{" +
                "imgId=" + imgId +
                ", name='" + name + '\'' +
                '}';
    }
}
