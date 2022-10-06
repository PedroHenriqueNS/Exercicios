package com.mycompany.calculadorarmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author pedro
 */
public class CalculadoraIntegrationTest {
    
    private CalculadoraServiceImpl calculadoraService;
    
    @Before
    public void init() {
        try {
            
            calculadoraService = new CalculadoraServiceImpl();
            calculadoraService.createStubAndBind();
        } catch (RemoteException e) {
            fail("Exception Occured: " + e);
        }
    }
    
    @Test
    public void whenClientSendsCalculoToServer_ThenServerSendsResponseCalculo() {
        try {
            
            float num1 = 2;
            float num2 = 2;
            
            float expectedResult = 4;
            
            Registry registry = LocateRegistry.getRegistry();
            CalculadoraService server = (CalculadoraService) registry.lookup("CalculadoraService");
            float responseCalculo = server.sendCalculoSoma(num1, num2);
            
            assertEquals(expectedResult, responseCalculo);
            System.out.println(expectedResult + " || " + responseCalculo);
            System.out.println("Deu certo!");
        } catch (RemoteException | NotBoundException e) {
            fail("Exception Occured: " + e);
        }
    }
}
