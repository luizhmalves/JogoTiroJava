/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro.municaoNivel2;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author luiz
 */
public class Municao {
    private Image imagem;
    private int x,y;
    private int largura, altura;
    private boolean Visivel;
    //private static final int ALTURA_TELA = 600;
    private static final int VELOCIDADE = 13;//retirar como constante
    
    public static void main(String[] args) {
        
    }
    public Municao(int x, int y){
        this.x = x;
        this.y = y;
        ImageIcon referencia = new ImageIcon("res//bala.png");
        imagem = referencia.getImage();
        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
        Visivel = true;
    }
    public void mexer(){
        this.y -= VELOCIDADE;
        if(y < 0){
            Visivel = false;
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

    public boolean getVisivel() {
        return Visivel;
    }

    public void setVisivel(boolean Visivel) {
        this.Visivel = Visivel;
    }
     public Rectangle getBounds(){
        return new Rectangle(x, y, largura, altura);
    }
}
