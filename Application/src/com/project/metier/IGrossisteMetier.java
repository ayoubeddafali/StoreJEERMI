package com.project.metier;

import com.project.model.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IGrossisteMetier extends Remote{
    boolean register(String username, String password, String type) throws RemoteException;
    boolean addProduct(String username, String product_name, String product_price) throws RemoteException;
    ArrayList<Product> getBuyedProducts(String username) throws  RemoteException;
    int getSumBuyedProducts(String username) throws  RemoteException;
}
