/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author luiz
 */
public class Reflexao1 {
    public Reflexao1(String path) throws MalformedURLException, ClassNotFoundException{
        ClassLoader classLoader = new URLClassLoader (new URL []{new URL (path)}, null);
        Class minhaClasse = classLoader.loadClass("Municao");
    }
}
