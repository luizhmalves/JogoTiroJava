/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogotiro;

import java.awt.Image;
import javax.swing.Timer;

/**
 *
 * @author Luiz Alves
 */
public interface Fase {
    void setTimer(Timer timer);
    void setFundo(Image fundo);
    Timer getTimer();
    void setArma(Arma arma);
    Arma getArma();
    Image getFundo();
}
