package com.project.dao;

public class DBUserQueries {
    public static String getUsers(){
        return "select * from users";
    }
    public static String insertUser(String username, String password, String type) {
        return "INSERT INTO users(username, password, type) VALUES ('" + username  + "'" +
                ", '" + password + "', '" + type + "')";
    }
    public static String selectUserById(int id){
        return "SELECT * FROM users where id=" + id ;
    }
    public static String selectUserByUsername(String name){
        return "SELECT * FROM users where username='" + name + "'" ;
    }
}

