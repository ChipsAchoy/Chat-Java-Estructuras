/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chatver2;

import java.io.Serializable;

/**
 *
 * @author A
 */
public class Paquete implements Serializable{
    private String myport, port, msg;
    
    public Paquete(String myport, String port, String msg){
        this.myport = myport;
        this.port = port;
        this.msg = msg;
    }
    public String getMyport(){
        return this.myport;
    }
    public String getPort(){
        return this.port;
    }
    public String getMsg(){
        return this.msg;
    }

}
