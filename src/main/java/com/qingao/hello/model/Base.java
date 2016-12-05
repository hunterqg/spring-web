package com.qingao.hello.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by qingao on 2016/11/28.
 */
public abstract class Base {
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss"/*,timezone = "GMT+8"*/)
    protected Date createAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss"/*,timezone = "GMT+8"*/)
    protected Date updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    private String getTimeZone() {
        return TimeZone.getDefault().getID();
    }
}
