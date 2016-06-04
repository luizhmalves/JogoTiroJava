/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author luiz
 */
public class Reflexao {
    public Reflexao(Object objeto){
        Class classe = objeto.getClass();
        System.out.println(classe);
        for (Field atributos : classe.getDeclaredFields()) {
            
            atributos.setAccessible(true);
            System.out.println(atributos);
            if(atributos.getName().equals("imagem")){
                
            }
        }
        System.out.println();
        for (Method metodos : classe.getDeclaredMethods()) {
            System.out.println(metodos);
            
        }
        
    }
    public static void main(String[] args) {
        Arma arma = new Arma();
        Reflexao reflex = new Reflexao(arma);
    }
}
