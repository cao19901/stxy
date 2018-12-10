package com.bootdo.clouddocommon.dto;

import java.io.Serializable;


public class UserToken implements Serializable{
    private static final long serialVersionUID = 1L;

    public UserToken(String username, String userId, String name) {
        this.userId = userId;
        this.username = username;
        this.name = name;
    }


    private String userId;

    private String username;

    private String name;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
