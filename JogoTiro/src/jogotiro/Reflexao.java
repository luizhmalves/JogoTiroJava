/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz
 */
public class Reflexao {
    RecebePath path = new RecebePath();

    

    public Tiro CriaMunicao(String classe){
        path.getPath().replace('/',File.separatorChar);
        File arquivo = new File(path.getPath());
        String[] classes = arquivo.list();
        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
        Tiro municao = null;
        for (int i = 0; i < classes.length; i++) {
            classes[i] = classes[i].replace(".java", "").trim();
            if(classes[i].equals(classe)){
                System.out.println(classes[i]);
                municao = null;
                Class municaoClass = null;
                try {
                    municaoClass = classLoader.loadClass("Tiros." + classe );
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Classe não encontrada.", "Erro!!!", JOptionPane.ERROR_MESSAGE);
                }
                try {
                    municao = (Tiro) municaoClass.newInstance();
                } catch (InstantiationException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o construtor.", "Erro!!!", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalAccessException ex) {
                    JOptionPane.showMessageDialog(null, "Falha na instância da classe", "Erro!!!", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
        if(municao != null){
            JOptionPane.showMessageDialog(null, "Atualização feita com Sucesso.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return municao;
        }else{
            JOptionPane.showMessageDialog(null, "Atualização mal sucedida", "Erro!!!", JOptionPane.ERROR_MESSAGE);
        }   return null;
    }
    
}
