/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Luiz Alves
 */
public class Arma1 implements Arma{
    int mira;
    int tiro;
    int x;
    int y;
    Image imagem;
       
    public Arma1(){
        
        ImageIcon referencia = new ImageIcon("res\\arma1.png");
        imagem = referencia.getImage();
        
        this.x = 200;
        this.y = 500;
    }
    
    public void mirar(){
        
    }
    @Override
    public void setMira(int mira) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTiro(int tiro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMira() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTiro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void setX(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setY(int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getX() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setArma(Image imagem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Image getArma() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent tecla) {
        int codigo = tecla.getKeyCode();
        
        if(codigo == KeyEvent.BUTTON1_MASK){
            /**confirmar código para o botão direito do mouse
            *   Atirar
            */
        }
        if(codigo == KeyEvent.MOUSE_EVENT_MASK){
            
            /*confirmar se captura o movimento do mouse
            *   Inserir mira
            */
        }
    }
    
}
