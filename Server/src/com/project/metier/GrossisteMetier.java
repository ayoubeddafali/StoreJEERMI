package com.project.metier;

import com.project.dao.DBProductQueries;
import com.project.dao.DBUserQueries;
import com.project.model.DBManager;
import com.project.model.Product;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GrossisteMetier  extends UnicastRemoteObject implements IGrossisteMetier {
    public GrossisteMetier() throws RemoteException {
    }

    @Override
    public boolean register(String username, String password, String type) throws RemoteException {
        DBManager dbm =  new DBManager(); // by default it connects to MYSQL
        // if you have another db, you specify it in the constructor
        try{
            if (!dbm.isConnected()){
                if (!dbm.openConnection()){
                    System.out.println("Could not connect to the database...");
                }
            }
            String insert_user_query = DBUserQueries.insertUser(username, password, type);
            if ( dbm.ExecuteNonQuery(insert_user_query)) {
                return true ;
            }else {
                return false;
            }
        }catch (Exception e ){
            System.out.println("Error connecting to DB for inserting Grossiste");
        }
        return false ;
    }
    @Override
    public boolean addProduct(String username, String product_name, String product_price) throws RemoteException{
        DBManager dbm = new DBManager();
        try {
            //connect to the db and open the connection
            if (!dbm.isConnected()) {
                if (!dbm.openConnection()) {
                    //massive failure, log it
                    throw new Exception("Error COnnextion DBMANAGER");
                }
            }
            String get_user_id  = DBUserQueries.selectUserByUsername(username);
            ResultSet r = dbm.ExecuteResultSet(get_user_id);
            int seller_id = 0;
            while(r.next()){
                seller_id = r.getInt("id");
            }
            String addProductQuery = DBProductQueries.addProduct(product_name, product_price, seller_id, "image.png");
            if(dbm.ExecuteNonQuery(addProductQuery) ){
                return true;
            }else {
                return false ;
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return false ;
    }
    @Override
    public ArrayList<Product> getBuyedProducts(String username) throws  RemoteException{ // username == seller of product
        ArrayList<Product> buyedProducts = new ArrayList<Product>();
        DBManager dbm = new DBManager();
        try {
            //connect to the db and open the connection
            if (!dbm.isConnected()) {
                if (!dbm.openConnection()) {
                    //massive failure, log it
                    System.out.println("Error COnnextion DBMANAGER");
                }
            }
            String get_user_id  = DBUserQueries.selectUserByUsername(username);
            ResultSet r = dbm.ExecuteResultSet(get_user_id);
            int user_id = 0;
            while(r.next()){
                user_id = r.getInt("id");
            }
            String query = DBProductQueries.getBuyedProducts(user_id);
            ResultSet rs = dbm.ExecuteResultSet(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                int buyer_id = rs.getInt("user_id");
                String buyer_name = "";
                String select_user_query = DBUserQueries.selectUserById(buyer_id);
                ResultSet seller = dbm.ExecuteResultSet(select_user_query);
                while(seller.next()){
                    buyer_name  = seller.getString("username");
                    buyedProducts.add(new Product(id, name, price, buyer_name, username));
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return buyedProducts;
        }
    @Override
    public int getSumBuyedProducts(String username) throws  RemoteException{
        int total = 0 ;
        DBManager dbm = new DBManager();
        try {
            //connect to the db and open the connection
            if (!dbm.isConnected()) {
                if (!dbm.openConnection()) {
                    //massive failure, log it
                    System.out.println("Error COnnextion DBMANAGER");
                }
            }
        String get_user_id  = DBUserQueries.selectUserByUsername(username);
        ResultSet r = dbm.ExecuteResultSet(get_user_id);
        int user_id = 0;
        while(r.next()){
            user_id = r.getInt("id");
        }
        String get_sum = DBProductQueries.getSumBuyedProducts(user_id);
        ResultSet sum_products = dbm.ExecuteResultSet(get_sum);
        while(sum_products.next()){
            total = Integer.parseInt(sum_products.getString("total"));
        }
    } catch (Exception e){
            e.printStackTrace();
        }
        return total;

    }


}
