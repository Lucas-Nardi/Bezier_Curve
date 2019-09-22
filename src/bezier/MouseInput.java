package bezier;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.opengl.GLWindow;

public class MouseInput implements MouseListener {

    private double x;
    private double y;
    public static int contador = 0;
    public static boolean fazerPonto = false;

    GLWindow window = Bezier.getWindow();

    @Override

    public void mouseClicked(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent me) {
        contador ++;
        
        if (contador == 1) {
            fazerPonto = true;
            EventListener.x1 = x;
            EventListener.y1 = y;
            
        }else if(contador == 2){
            fazerPonto = true;
            EventListener.x2 = x;
            EventListener.y2 = y;
            
        }else if(contador == 3){
            fazerPonto = true;
            EventListener.x3 = x;
            EventListener.y3 = y;
            
        }else if (contador == 4){
            fazerPonto = true;        
            
            EventListener.x4 = x;
            EventListener.y4 = y;
            contador = 0;
        }

    }

    @Override
    public void mouseReleased(MouseEvent me) {
        fazerPonto = false;
    }

    @Override
    public void mouseMoved(MouseEvent me) {

        x = me.getX();       
        y = me.getY();
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {

    }

    @Override
    public void mouseWheelMoved(MouseEvent e) {

    }

}
