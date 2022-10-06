package com.mycompany.calculadorarmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author pedro
 */
public interface CalculadoraService extends Remote {
    
    public float sendCalculoSoma(float num1, float num2) throws RemoteException;
}
