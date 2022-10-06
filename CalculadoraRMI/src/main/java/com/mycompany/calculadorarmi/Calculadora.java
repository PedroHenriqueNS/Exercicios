package com.mycompany.calculadorarmi;

import java.io.Serializable;

/**
 *
 * @author pedro
 */
public class Calculadora implements Serializable {
    
    public Calculadora() {}
    
    public float soma(float num1, float num2) {
        return num1 + num2;
    }
    
}
