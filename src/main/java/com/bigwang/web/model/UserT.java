package com.bigwang.web.model;

public class UserT {
    /**
     * 
     */
    protected Integer id;

    /**
     * 
     */
    protected String userName;

    /**
     * 
     */
    protected String password;

    /**
     * 
     */
    protected Integer age;

    /**
     * user_t.id
     */
    public Integer getId() {
        return id;
    }

    /**
     * user_t.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * user_t.user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * user_t.user_name
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * user_t.password
     */
    public String getPassword() {
        return password;
    }

    /**
     * user_t.password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * user_t.age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * user_t.age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}