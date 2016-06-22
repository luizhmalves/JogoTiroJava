/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import javax.swing.JOptionPane;

/**
 *
 * @author luiz
 */
public class Reflexao {
    public Reflexao(String classe){
        
        
        ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
        MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
        try {
            Class meuObjetoClasse = classLoader.loadClass(classe);// captura a classe
            Tiro objetoInterface = (Tiro) meuObjetoClasse.newInstance();
            Arma objetoMunicao = (Arma) meuObjetoClasse.newInstance();//Instancia a nclasse
        }catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível acessar construtor.", "Erro!!!", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar a classe.", "Erro!!!", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Falha na instanciação.", "Erro!!!", JOptionPane.ERROR_MESSAGE);
        }
        
    }    
}
