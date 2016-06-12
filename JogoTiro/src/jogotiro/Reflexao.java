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

    public Reflexao() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader parentClassLoader = CarregamentoReflexao.class.getClassLoader();
        CarregamentoReflexao classLoader = new CarregamentoReflexao(parentClassLoader);
        Class minhaClasseObjeto = classLoader.loadClass("Municao");
        Tiro objeto1 = (Tiro) minhaClasseObjeto.newInstance();
        Object objeto2 = (Object) minhaClasseObjeto.newInstance();
        
        
    }
}
