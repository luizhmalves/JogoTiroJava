/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz
 */
public class MyClassLoader extends ClassLoader {
    
    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }


    public Class loadClass(String name, String path) throws ClassNotFoundException {
        if("Municao".equals(name)){
            return super.loadClass(name);
        }
        String url = path;
        try {
            URL minhaUrl = new URL (url);
            URLConnection conecta = minhaUrl.openConnection();
            InputStream entrada = conecta.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = entrada.read();
            
            while(data != -1){
                buffer.write(data);
                data = entrada.read();
            }
            entrada.close();
            byte[] classData = buffer.toByteArray();
            return defineClass("Municao", classData, 0, classData.length);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar o endereço.", "ERRO!!!", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar classe.", "ERRO!!!", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
