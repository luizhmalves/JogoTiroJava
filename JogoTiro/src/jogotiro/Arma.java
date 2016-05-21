/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Luiz Alves
 */
public class Arma{
    private int x;
    private int y;
    private int dx;
    private int dy;
    private boolean Visivel;    
    private int largura, altura;
    private Image imagem;
    private List<Municao> municoes;   
    public Arma(){
        
        ImageIcon referencia = new ImageIcon("res//metralhadora.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
        municoes = new ArrayList<Municao>();
        this.x = 400;
        this.y = 402;
    }
    //Modificar essa classe
    public void moverDireita(){
        x -=dx;
    }
    public void moverEsquerda(){
        x +=dx;
    }
    public List<Municao> getMunicoes() {
        return municoes;
    }
    
    public int getX() {
        return x;
    }

    
    public int getY() {
        return y;
    }
    
    public Image getArma() {
        return imagem;
    }
    
    public void atira(){
        this.municoes.add(new Municao(x + largura, y + altura/2));
    }
    public boolean getVisivel() {
        return Visivel;
    }

    public void setVisivel(boolean Visivel) {
        this.Visivel = Visivel;
    }
    public Rectangle getBounds(){
        return new Rectangle(x, y, largura, altura);
    }
    
    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        
        if(codigo == KeyEvent.VK_LEFT){
           
            moverEsquerda();
            
        }
        if(codigo == KeyEvent.VK_RIGHT){
            
            moverDireita();
        }
    }

    
    public void keyReleased(KeyEvent tecla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
