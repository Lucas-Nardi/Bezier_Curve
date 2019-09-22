package bezier;

import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.opengl.GLWindow;

public class MouseInput implements MouseListener {

    private double x;
    private double y;
    public static int contador = 0;
    public static boolean fazerPonto = false;
    public static int i=0, j=0;

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
        
        
        if (contador == 0 && EventListener.qtdPonto == 0) {
            
            fazerPonto = true;            
            EventListener.qtdPonto = 1;
            EventListener.TodosPontos[i][0] = x;
            EventListener.TodosPontos[i][1] = y;
            i++;
            contador++;
        }else if(contador == 1 && EventListener.qtdPonto == 1){
            fazerPonto = true;            
            EventListener.qtdPonto = 2;
            EventListener.TodosPontos[i][0] = x;
            EventListener.TodosPontos[i][1] = y;
            i++;
            contador++;
            
        }else if(contador == 2 && EventListener.qtdPonto == 2){
            fazerPonto = true;            
            EventListener.qtdPonto = 3;
            EventListener.TodosPontos[i][0] = x;
            EventListener.TodosPontos[i][1] = y;
            i++;
            contador++;
            
        }else if (contador == 3 && EventListener.qtdPonto == 3){
            fazerPonto = true;        
            EventListener.qtdPonto = 4;            
            EventListener.TodosPontos[i][0] = x;
            EventListener.TodosPontos[i][1] = y;
            i++;
            contador = 0;
        }else{                    // JÁ TENHO OS 4 PONTOS INICIAIS E QUERO ADICIONAR MAIS PONTOS
           
            
            EventListener.TodosPontos[i][j] = x;
            if(j==0){
                j++;
            }
            EventListener.TodosPontos[i][j] = x;
            if(j==1){
                j=0;
                i++;
            }
            fazerPonto = true;
            contador = 1;            
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
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
