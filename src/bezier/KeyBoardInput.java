package bezier;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class KeyBoardInput implements KeyListener{

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_P){
            
            System.out.println("EXIBA O POLINOMIO ASDDADA");
            
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
