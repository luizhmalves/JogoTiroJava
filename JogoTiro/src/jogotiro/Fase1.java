/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Luiz Alves
 */
public class Fase1 extends JPanel implements ActionListener {

    private Image fundo;
    private Arma arma;
    private Timer timer;
    private boolean emJogo;
    private List<Alvo> alvos;
    private int[][] coordenadas = {{2380,29}, {2600,59}, {1380,89},{780,109}};/*,
                                   {580,139}, {880,239}, {790,259}, {760,50},
                                   {790,150}, {1980,209}, {560,45}, {510,70},
                                   {930,159}, {590,80}, {530,60}, {940,59},
                                   {990,30}, {920,200}, {900,259}, {660,50},
                                   {540,90}, {810,220}, {860,20}, {740,180},
                                   {820,128}, {490,170},{700,30}, {920,300},
                                   {856,328}, {456,320}};*/
    //criar matriz com as posições dos alvos
    
    public Fase1() {
        setFocusable(true);
        setDoubleBuffered(true);
        addKeyListener(new TecladoAdapter());
        ImageIcon referencia = new ImageIcon("res//forest.jpg");
        fundo = referencia.getImage();
        arma = new Arma();
        emJogo = true;
        
        inicializaAlvo();
        timer = new Timer(5, this);
        timer.start();

    }
    
    public void inicializaAlvo() {
        this.alvos = new ArrayList<Alvo>();
        
        for (int i = 0; i < coordenadas.length; i++) {
            alvos.add(new Alvo(coordenadas[i][0], coordenadas[i][1]));
        }
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

    public void paint(Graphics g) {
        Graphics2D graficos = (Graphics2D) g;
        graficos.drawImage(fundo, 0, 0, null);

        if (emJogo) {
            graficos.drawImage(arma.getArma(), arma.getX(), arma.getY(), this);
            List<Municao> municoes = arma.getMunicoes();
            for (int i = 0; i < municoes.size(); i++) {
                Municao bala = (Municao) municoes.get(i);
                graficos.drawImage(bala.getImagem(), bala.getX(), bala.getY(), this);
            }
            for (int i = 0; i < alvos.size(); i++) {
                Alvo alvo = (Alvo) alvos.get(i);
                graficos.drawImage(alvo.getImagem(), alvo.getX(), alvo.getY(), this);
            }
            graficos.setColor(Color.red);
            graficos.drawString("ALVOS :" + alvos.size(), 5, 15);
        }
        g.dispose();
    }

    public void checarColisoes() {
        Rectangle formaArma = arma.getBounds();
        Rectangle formaAlvo;
        Rectangle formaMunicao;

        for (int i = 0; i < alvos.size(); i++) {
            Alvo tempAlvo = alvos.get(i);
            formaAlvo = tempAlvo.getBounds();
            if (formaArma.intersects(formaAlvo)) {
                arma.setVisivel(false);
                tempAlvo.setVisivel(false);
                emJogo = false;
            }
        }
        List<Municao> balas = arma.getMunicoes();

        for (int i = 0; i < balas.size(); i++) {
            Municao tempBalas = balas.get(i);
            formaMunicao = tempBalas.getBounds();
            for (int j = 0; j < alvos.size(); j++) {
                Alvo tempAlvo = alvos.get(j);
                formaAlvo = tempAlvo.getBounds();
                if (formaMunicao.intersects(formaAlvo)) {
                    tempAlvo.setVisivel(false);
                    tempBalas.setVisivel(false);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        arma.mover();
        if (alvos.size() == 0) {
            emJogo = false;
        }
        List<Municao> municoes = arma.getMunicoes();
        for (int i = 0; i < municoes.size(); i++) {
            Municao bala = (Municao) municoes.get(i);
            if (bala.getVisivel()) {
                bala.mexer();
            } else {
                municoes.remove(i);
            }
        }

        for (int i = 0; i < alvos.size(); i++) {
            Alvo alvo = (Alvo) alvos.get(i);
            if (alvo.getVisivel()) {
                alvo.mexer();
            } else {
                alvos.remove(i);
            }
        }
        checarColisoes();
        repaint();
    }

    private class TecladoAdapter extends KeyAdapter {
        
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                emJogo = true;
                arma = new Arma();
                inicializaAlvo();
            }
            
            arma.keyPressed(e); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            arma.keyReleased(e); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
