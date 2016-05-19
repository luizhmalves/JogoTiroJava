/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import javax.swing.JFrame;

/**
 *
 * @author Luiz Alves
 */
public class GerenciaTela extends JFrame{

    public GerenciaTela(){
        this.setTitle("Tiro ao Alvo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
