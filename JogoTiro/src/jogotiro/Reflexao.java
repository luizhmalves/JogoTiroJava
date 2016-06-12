/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;



/**
 *
 * @author Luiz Alves
 */
public class Reflexao extends ClassLoader {
    ClassLoader parentClassLoader = CarregamentoReflexao.class.getClassLoader();
    CarregamentoReflexao classeCarregada = new CarregamentoReflexao(parentClassLoader); 
    
}
