/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

/**
 *
 * @author luiz
 */
public class Reflexao extends ClassLoader {
    public Reflexao(String endereco) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
        Class minhaClasseObjeto = classLoader.loadClass("Municao", endereco);
        Tiro Municao = (Tiro) minhaClasseObjeto.newInstance();
        Object MunicaoObjeto = (Object) minhaClasseObjeto.newInstance();
    }
}
