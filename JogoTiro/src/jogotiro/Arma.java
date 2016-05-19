/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.awt.Image;
import java.awt.event.KeyEvent;

/**
 *
 * @author Luiz Alves
 */
public interface Arma {
    void setMira(int mira);
    void setArma(Image imagem);
    void setTiro(int tiro);
    void setX(int x);
    void setY(int y);
    int getMira();
    Image getArma();
    int getTiro();
    int getX();
    int getY();
    void mirar();
    void keyPressed(KeyEvent tecla);
}
