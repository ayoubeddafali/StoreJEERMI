package com.project.dao;


public  class DBProductQueries {
    public static String getProducts(){
        return "SELECT * FROM products";
    }
    public static String getNonPurchasedProducts(int user_id){
        return "SELECT * FROM products where id not in ( select product_id from user_product " +
                " where user_id =" + user_id + ")";
    }
    public static String attachUserProduct(int user_id, int product_id){
        return "INSERT INTO user_product(user_id, product_id) " +
                "values(" + user_id + "," + product_id +" ) ";
    }
    public static String getPurchasedProducts(int user_id){
        return "SELECT * FROM products where id in ( select product_id from user_product " +
                " where user_id =" + user_id + ")";
    }
    public static String addProduct(String name, String price, int seller, String image){
        return "INSERT INTO products(name, price, seller, image) " +
                "VALUES ('" +  name + "', '" + price +"', " + seller +",'" + image  +"')";
    }
    public static  String getMyProducts(int user_id ){
        return "SELECT * FROM products where seller=" + user_id;
    }
    public static String getBuyedProducts(int user_id){
        return "SELECT * from products " +
                " JOIN user_product ON products.id = user_product.product_id " +
               " where seller ="  + user_id;
    }
    public static String getSumBuyedProducts(int user_id){
        return "SELECT sum(price) as total  from products " +
                " JOIN user_product ON products.id = user_product.product_id " +
               " where seller ="  + user_id;
    }
}
