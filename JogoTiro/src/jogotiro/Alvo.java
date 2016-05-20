/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Luiz Alves
 */
public class Alvo {
    private Image imagem;
    private int x,y;
    private int altura,largura;
    private boolean isVisivel;
    private static final int ALTURA_TELA = 500;
    private static final int LARGURA_TELA = 400;
    private static final int VELOCIDADE = 1;
    
    public Alvo(int x, int y){
        this.x = x;
        this.y = y;
        ImageIcon referencia = new ImageIcon();
        imagem = referencia.getImage();
        largura = imagem.getWidth(null);
        altura = imagem.getHeight(null);
        isVisivel = true;
    }
    public void mexer(){
        if(this.x < 0){
            this.x = LARGURA_TELA;
        }else{
            this.x -= VELOCIDADE;
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
    public Rectangle getBounds(){
        return new Rectangle(x, y, largura, altura);
    }
}
