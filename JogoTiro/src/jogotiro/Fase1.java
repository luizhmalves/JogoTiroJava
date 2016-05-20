/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Luiz Alves
 */
public class Fase1 extends JPanel implements ActionListener{
    private Image fundo;
    private Arma arma;
    private Timer timer;
    
    public Fase1(){
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new MouseAdapter());
        ImageIcon referencia = new ImageIcon("res\\metalPlateFloorBump.png");
        fundo = referencia.getImage();
        arma = new Arma1();
        timer = new Timer(5, this);
        timer.start();
        
    }

    public Image getFundo() {
        return fundo;
    }

    public void setFundo(Image fundo) {
        this.fundo = fundo;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
    public void paint(Graphics g){
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);
        graficos.drawImage(arma.getArma(), arma.getX(), arma.getY(), this);
        List<Municao> municoes = arma.getMunicoes();
        for(int i = 0; i < municoes.size(); i ++){
            Municao bala = (Municao) municoes.get(i);
            graficos.drawImage(bala.getImagem(), bala.getX(), bala.getY(), this);
        }
        g.dispose();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        List<Municao> municoes = arma.getMunicoes();
        for(int i = 0; i < municoes.size(); i ++){
            Municao bala = (Municao) municoes.get(i);
            if(bala.isIsVisivel()){
                bala.mexer();
            }else{
                municoes.remove(i);
            }
        }

        //arma.getMira();
        //arma.getTiro();
        repaint();
    }
    private class MouseAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            arma.keyPressed(e); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            arma.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
