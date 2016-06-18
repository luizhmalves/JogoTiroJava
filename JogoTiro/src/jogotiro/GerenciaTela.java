/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

/**
 *
 * @author Luiz Alves
 */
public class GerenciaTela extends JFrame {

    private String path;
    private static ArrayList<String> classeTemp = new ArrayList<String>();
    private Reflexao reflexao;
    
    public GerenciaTela() {
        JMenuItem municaoNivel1;
        JMenuItem municaoNivel2;
        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenu atualiza = new JMenu("Atualizar");
        atualiza.add(municaoNivel1 = new JMenuItem("Munição Nivel 1"));
        atualiza.add(new JSeparator());
        //atualiza.add(municaoNivel2 = new JMenuItem("Munição Nivel 2"));
        municaoNivel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path = "src/jogotiro/municaoNivel2/";
                File caminho = new File(path);
                String[] classes = caminho.list();
                for (String classe1 : classes) {
                    String classe2 = classe1.replace(".java", "").trim();
                    classeTemp.add(classe2);
                }
                String classe = "";
                for (int i = 0; i < classeTemp.size(); i++) {
                    classe = classeTemp.get(i) + classe;
                    
                }
                JOptionPane.showMessageDialog(null, classe);
                reflexao = new Reflexao(classe);
                
                //JOptionPane.showMessageDialog(null, "Munição Nivel 2 adicionado com sucesso.");
            }
        });
        
                
        /* atualiza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                caminho = new RecebePath();
                caminho.setPath(FileChooser());
                path = caminho.getPath();
                JOptionPane.showMessageDialog(null, path);

            }
        });*/
        JMenuItem sobre = new JMenuItem("Sobre");
        sobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Jogo desenvolvido por Luiz Alves!", "Informações", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JMenuItem sair = new JMenuItem("Sair");

        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        
        menu.add(atualiza);
        
        menu.add(new JSeparator());
        menu.add(sobre);
        menu.add(new JSeparator());
        menu.add(sair);
        barraMenu.add(menu);
        setJMenuBar(barraMenu);
        add(new Fase1());
        this.setTitle("Tiro ao Alvo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

    }

    public String getPath() {
        return this.path;
    }

    private String FileChooser() {
        String caminhoArquivo = "";
        JFileChooser arquivo = new JFileChooser();
        int retorno = arquivo.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            caminhoArquivo = arquivo.getSelectedFile().getAbsolutePath();

        }
        return caminhoArquivo;
    }
}
