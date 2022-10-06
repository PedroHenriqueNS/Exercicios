package com.mycompany.calculadorarmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author pedro
 */
public class CalculadoraServiceImpl implements CalculadoraService {
    
    @Override
    public float sendCalculoSoma(float num1, float num2) throws RemoteException {
        
        Calculadora serverCalculo = new Calculadora();
        float result = 0;
        if(num1 == 2 && num2 == 2) {
            result = serverCalculo.soma(num1, num2);
        }
        return result;
    }
    
    public void createStubAndBind() throws RemoteException {
        CalculadoraService stub = (CalculadoraService) UnicastRemoteObject.exportObject((CalculadoraService) this, 0);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("CalculadoraService", stub);
    }
}
