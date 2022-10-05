package com.mycompany.dataformatadasockettcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author pedro
 */
public class Cliente {

    static Socket socket;

    public Cliente() {
        try {
            socket = new Socket("localhost", 9600);
        } catch (IOException e) {
            System.out.println("Não consegui realizar a conexão.\nCódigo do erro: " + e);
        }
    }
    
    public static void main(String args[]) throws Exception {
        new Cliente();
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2003, Calendar.JUNE, 8);
        Date date = calendar.getTime();
        
        Pessoa pessoa = new Pessoa(1L, "Pedro", "Henrique", "12345678900", date);
        
        final ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        final ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(pessoa);
        final byte[] data = baos.toByteArray();
        
        OutputStream out;
        try {
            out = socket.getOutputStream();
            out.write(data);
        } catch (IOException e) {
            System.out.println("Erro no envio de dados ao servidor.\nCódigo do erro: " + e);
        }
        
        try {
            socket.close();
        } catch (IOException e) {
            System.out.println("A conexão não foi encerrada corretamente.\nCódigo do erro: " + e);
        }
    }
}
