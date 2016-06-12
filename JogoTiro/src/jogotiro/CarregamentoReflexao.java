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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiz Alves
 */
public class CarregamentoReflexao extends ClassLoader{
    GerenciaTela caminho = new GerenciaTela();

    public CarregamentoReflexao(ClassLoader pai) {
        super(pai);
        

    }
    public Class loadClass(String name)throws ClassNotFoundException{
        if(!"Municao".equals(name)){
            return super.loadClass(name);
        }
        try{
            String url = caminho.getPath();
            URL meuEndereco = new URL(url);
            URLConnection conexao = meuEndereco.openConnection();
            InputStream input = conexao.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();
            
            while(data != -1){
                buffer.write(data);
                data = input.read();
            }
            
            input.close();
            byte[] classData = buffer.toByteArray();
            return defineClass("Municao", classData, 0, classData.length);
        } catch (MalformedURLException e){
           JOptionPane.showMessageDialog(null, "Não foi possível definir URL.", "Erro!!!", 0);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"Não foi possível carregar classe.", "Erro!!!", 0);
        }
        
        return null;
    }
}
