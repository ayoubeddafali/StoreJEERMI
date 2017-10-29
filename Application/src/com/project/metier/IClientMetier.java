package com.project.metier;

import com.project.model.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IClientMetier extends Remote{
    public boolean register(String username, String password, String type) throws RemoteException;
    boolean purchaseProduct(String username, int product_id) throws RemoteException;
    ArrayList<Product> getProducts(String username, String type) throws  RemoteException;
    ArrayList<Product> getPurchasedPrducts(String username) throws  RemoteException;


}
