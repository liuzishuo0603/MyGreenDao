package com.example.dell.myapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by DELL on 2019/5/29.
 */
@Entity
public class RootBean {
    @Id(autoincrement = true)
    private Long id;
    private String data;
    @Generated(hash = 1272503684)
    public RootBean(Long id, String data) {
        this.id = id;
        this.data = data;
    }
    @Generated(hash = 636722272)
    public RootBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getData() {
        return this.data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
