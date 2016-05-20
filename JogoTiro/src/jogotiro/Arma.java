/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 *
 * @author Luiz Alves
 */
public interface Arma {
    void atira();
    void setMira(int mira);
    void setArma(Image imagem);
    void setX(int x);
    void setY(int y);
    int getMira();
    Image getArma();
    List<Municao> getMunicoes();
    int getX();
    int getY();
    void mirar();
    void keyPressed(KeyEvent tecla);
    void keyReleased(KeyEvent tecla);
    Rectangle getBounds();
}
