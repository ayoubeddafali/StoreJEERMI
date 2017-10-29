package com.project.dao;


public abstract class DBUserInfo {
    private String uid;
    private String pwd;
    private String cat;

    public DBUserInfo() {
    }

    public DBUserInfo(String uid, String pwd, String cat) {

        this.uid = uid;
        this.pwd = pwd;
        this.cat = cat;
    }

    public String getUserID()
    {
        return uid;
    }

    public void setUserID(String value)
    {
        uid = value;
    }

    public String getPassword()
    {
        return pwd;
    }

    public void setPassword(String value)
    {
        pwd = value;
    }

    public String getCatalog()
    {
        return cat;
    }

    public void setCatalog(String catalog)
    {
        cat = catalog;
    }
}
