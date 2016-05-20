/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * @author Luiz Alves
 */
public interface Tiro {
    void mexer();
    Image getImagem();
    int getX();
    int getY();
    boolean getVisivel();
    void setVisivel(boolean Visivel);
    Rectangle getBounds();
}
