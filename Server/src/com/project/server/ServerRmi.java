package com.project.server;

import com.project.metier.ClientMetier;
import com.project.metier.GrossisteMetier;
import com.project.metier.IClientMetier;
import com.project.metier.IGrossisteMetier;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerRmi {
    public static void main(String[] args ) throws RemoteException, MalformedURLException,
            AlreadyBoundException
    {
        LocateRegistry.createRegistry(1099);
        IClientMetier client = new ClientMetier(); // skeleton & stub
        IGrossisteMetier grossite = new GrossisteMetier(); // skeleton & stub
        Naming.bind("rmi://localhost/client", client);
        Naming.bind("rmi://localhost/grossiste", grossite);
        System.out.println("Serveur RMI en écoute");
    }
}
