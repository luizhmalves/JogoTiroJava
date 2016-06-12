/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiz Alves
 */
public class CarregamentoReflexao extends ClassLoader{
    

    public CarregamentoReflexao(String nome) {
    ClassLoader classeCarregada = CarregamentoReflexao.class.getClassLoader();
        try {
            Class carregada = classeCarregada.loadClass(nome);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarregamentoReflexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
