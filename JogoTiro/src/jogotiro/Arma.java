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
    private boolean Visivel;    
    private int largura, altura;
    private Image imagem;
    private List<Municao> municoes;   
    public Arma(){
        
        ImageIcon referencia = new ImageIcon("res\\arma1.png");
        imagem = referencia.getImage();
        altura = imagem.getHeight(null);
        largura = imagem.getWidth(null);
        municoes = new ArrayList<Municao>();
        this.x = 0;
        this.y = 0;
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
        
        if(codigo == KeyEvent.BUTTON1_MASK){
            /**confirmar código para o botão direito do mouse
            *   Atirar
            */
            atira();
            
        }
        if(codigo == KeyEvent.MOUSE_EVENT_MASK){
            
            /*confirmar se captura o movimento do mouse
            *   Inserir mira
            */
        }
    }

    
    public void keyReleased(KeyEvent tecla) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
