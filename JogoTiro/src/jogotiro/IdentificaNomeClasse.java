/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author luiz
 */

public class IdentificaNomeClasse {
    public String minhaClasse;
    public static String classe;
    private ArrayList<String> classeTemp = new ArrayList<String>();
    private Reflexao reflexao;
   
    public IdentificaNomeClasse(String caminho){
        SeparaNome(caminho);
        reflexao = new Reflexao(getMinhaClasse());
        
    }
    private void SeparaNome(String caminhoCompleto){
        caminhoCompleto.replace('/', File.separatorChar);
        File caminho = new File(caminhoCompleto);
        String[] classes = caminho.list();
        for (int i = 0; i < classes.length; i++) {
            classes[i] = classes[i].replace(".java", "").trim();
            classe = classes[i];
            
        }
        
        setMinhaClasse(classe);
    }
     public String getMinhaClasse() {
        return minhaClasse;
    }

    public void setMinhaClasse(String minhaClasse) {
        this.minhaClasse = minhaClasse;
    }
    
}
