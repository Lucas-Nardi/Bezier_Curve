package bezier;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyBoardInput implements KeyListener{
    
    public static boolean mexerPonto = false;
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_P){
            
            System.out.println("EXIBA O POLINOMIO ASDDADA");
            
        }
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){ // PODER MOVER OS PONTOS
            
            mexerPonto = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_CONTROL){ // PODER MOVER OS PONTOS
            
            mexerPonto = false;
            MouseInput.pegou = false;
        }
    }
    
}
