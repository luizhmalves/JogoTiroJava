/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import com.sun.org.apache.xerces.internal.util.DOMUtil;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Luiz Alves
 */
public class Municao {
    private Image imagem;
    private int x,y;
    private boolean isVisivel;
    private static final int ALTURA_TELA = 500;
    private static final int VELOCIDADE = 2;
    
    public Municao(int x, int y){
        this.x = x;
        this.y = y;
        ImageIcon referencia = new ImageIcon();
        imagem = referencia.getImage();
        isVisivel = true;
    }
    public void mexer(){
        this.y -= VELOCIDADE;
        if(y > ALTURA_TELA){
            isVisivel = false;
        }
    }

    public Image getImagem() {
        return imagem;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isIsVisivel() {
        return isVisivel;
    }

    public void setIsVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }
    
}
