/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz
 */
public class Reflexao {
    public Reflexao(String classe){
        System.out.println(classe);
        /*Class meuObjetoClasse = null;
        try {
            meuObjetoClasse = Class.forName(classe);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Reflexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(meuObjetoClasse.getTypeName());*/
        
        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
        try {
            Class meuObjetoClasse = classLoader.loadClass(classe);// captura a classe
            Tiro objetoInterface = (Tiro) meuObjetoClasse.newInstance();
            Municao objetoMunicao = (Municao) meuObjetoClasse.newInstance();//Instancia a nclasse
        }catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar construtor.", "Erro!!!", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar a classe.", "Erro!!!", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Falha na instanciação.", "Erro!!!", JOptionPane.ERROR_MESSAGE);
        }
        
    }    
}
