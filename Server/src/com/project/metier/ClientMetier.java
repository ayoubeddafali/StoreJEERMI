package com.project.metier;

import com.project.dao.DBProductQueries;
import com.project.dao.DBUserQueries;
import com.project.model.DBManager;
import com.project.model.Product;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClientMetier  extends UnicastRemoteObject implements IClientMetier {

    public ClientMetier() throws RemoteException {
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
            System.out.println("Error connecting to DB for inserting Client");
        }
        return false ;
    }

    @Override
    public ArrayList<Product> getProducts(String username, String type) throws  RemoteException {
        // return non buyed produts if Client, return owned produts if Grossiste
        ArrayList<Product> products = new ArrayList<Product>();
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
            String query = "";
            if (type.equalsIgnoreCase("client")){
                query = DBProductQueries.getNonPurchasedProducts(user_id);
            }else if (type.equalsIgnoreCase("grossiste")){
                query = DBProductQueries.getMyProducts(user_id);
            }
            ResultSet rs = dbm.ExecuteResultSet(query);
            while(rs.next()){
                int product_id = rs.getInt("id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                int seller_id = rs.getInt("seller");
                String seller_name = "";
                String select_user_query = DBUserQueries.selectUserById(seller_id);
                ResultSet seller = dbm.ExecuteResultSet(select_user_query);
                while(seller.next()){
                    seller_name  = seller.getString("username");
                    products.add(new Product(product_id, name, price, "", seller_name));
                }
              }
        }
         catch (Exception e){
            e.printStackTrace();
        }
        return  products;
    }

    public boolean purchaseProduct(String username, int product_id) throws  RemoteException{
        DBManager dbm = new DBManager();
        try {
            //connect to the db and open the connection
            if (!dbm.isConnected()) {
                if (!dbm.openConnection()) {
                    //massive failure, log it
                    System.out.println("Error connecting database");
                }
            }
            String get_user_id  = DBUserQueries.selectUserByUsername(username);
            ResultSet rs = dbm.ExecuteResultSet(get_user_id);
            int user_id = 0;
            while(rs.next()){
                user_id = rs.getInt("id");
            }
            String attachUserProductQuery = DBProductQueries.attachUserProduct(user_id, product_id);
            if (dbm.ExecuteNonQuery(attachUserProductQuery)){
                return true ;
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return false ;
    }

    public ArrayList<Product> getPurchasedPrducts(String username) throws RemoteException{
        ArrayList<Product> purchasedProducts = new ArrayList<Product>();
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
            String query = DBProductQueries.getPurchasedProducts(user_id);
            ResultSet rs = dbm.ExecuteResultSet(query);
            while(rs.next()){
                int product_id = rs.getInt("id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String image = rs.getString("image");
                int seller_id = rs.getInt("seller");
                String seller_name = "";
                String select_user_query = DBUserQueries.selectUserById(seller_id);
                ResultSet seller = dbm.ExecuteResultSet(select_user_query);
                while(seller.next()){
                    seller_name  = seller.getString("username");
                    purchasedProducts.add(new Product(product_id, name, price, "",seller_name));
                }
         }
        }
         catch (Exception e){
            e.printStackTrace();
                }
            return purchasedProducts;
    }



}
