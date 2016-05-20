/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class GerenciaTela extends JFrame{

    public GerenciaTela(){
        JMenuBar barraMenu = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem sobre = new JMenuItem("Sobre");
        sobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Jogo desenvolvido por Luiz Alves!", "Informações",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JMenuItem sair = new JMenuItem("Sair");
        
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });
        menu.add(sobre);
        menu.add(new JSeparator());
        menu.add(sair);
        barraMenu.add(menu);
        setJMenuBar(barraMenu);
        add(new Fase1());
        this.setTitle("Tiro ao Alvo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
