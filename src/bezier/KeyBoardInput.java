package bezier;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.opengl.GLWindow;

public class KeyBoardInput implements KeyListener {

    public static boolean mexerPonto = false;
    private GLWindow window = Bezier.getWindow();    
    String poly;
    public static boolean aparecerPolinomios = false;
    public static int sumirFrase = 0;

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_P) {
            
            if(sumirFrase == 0){
                aparecerPolinomios = true;
                sumirFrase = 1;
            }else{
                aparecerPolinomios = false;
                sumirFrase = 0;
            }
            
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) { // PODER MOVER OS PONTOS

            mexerPonto = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_Q || e.getKeyCode() == KeyEvent.VK_ESCAPE) { // PODER MOVER OS PONTOS
            window.getAnimator().stop();
            window.destroy();
        }
        if (e.getKeyCode() == KeyEvent.VK_F) { // DEIXAR FULL SCREEN
            window.setFullscreen(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_M) { // TIRAR O FULL SCREEN
            window.setFullscreen(false);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_CONTROL) { // PODER MOVER OS PONTOS

            mexerPonto = false;
            MouseInput.pegou = false;
        }
    }

}
