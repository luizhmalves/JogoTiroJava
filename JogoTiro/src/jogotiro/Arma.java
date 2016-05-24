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
        
        ImageIcon referencia = new ImageIcon("res//arma.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
        municoes = new ArrayList<Municao>();
        this.x = 400;
        this.y = 419;
    }
    //Mudar colocar em relação ao tamanho da tela e da imagem fazer uma função
    public void mover(){
        x +=dx;
        if(x < 0){
            x = 0;
        }
       if(x > 730){
            x = 730;
        }
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
        this.municoes.add(new Municao(x + largura/3, y + altura/15));
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
        
        if(codigo == KeyEvent.VK_SPACE){
            atira();
        }
        if(codigo == KeyEvent.VK_LEFT){
           
            dx = -1;
            
        }
        if(codigo == KeyEvent.VK_RIGHT){
            
            dx = 1;
        }
    }

    
    public void keyReleased(KeyEvent tecla) {
        
        int codigo = tecla.getKeyCode();
        
        if(codigo == KeyEvent.VK_LEFT){
           
            dx = 0;
            
        }
        if(codigo == KeyEvent.VK_RIGHT){
            
            dx = 0;
        }
        
    }
    
    
}
