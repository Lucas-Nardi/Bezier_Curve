package bezier;

import static bezier.EventListener.TodosPontos;
import com.jogamp.nativewindow.util.Point;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GL2;

public class MouseInput implements MouseListener {

    private int x;
    private int y;
    private Point dragPoint = null;
    private int quePonto = 0;
    public static int contador = 0;
    public static boolean fazerPonto = false;
    public static int i = 0, j = 0;
    public static double pontoInicialy;
    public static double pontoInicialx;
    GL2 g1;

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
            EventListener.TodosPontos[i] = new Point(x,y);             
            i++;
            contador++;
        } else if (contador == 1 && EventListener.qtdPonto == 1) {
            fazerPonto = true;
            EventListener.qtdPonto = 2;
            EventListener.TodosPontos[i] = new Point(x,y);
            i++;
            contador++;

        } else if (contador == 2 && EventListener.qtdPonto == 2) {
            fazerPonto = true;
            EventListener.qtdPonto = 3;
            EventListener.TodosPontos[i] = new Point(x,y);          
            i++;           
            contador++;

        } else if (contador == 3 && EventListener.qtdPonto == 3) {
            fazerPonto = true;
            EventListener.qtdPonto = 4;
            EventListener.TodosPontos[i] = new Point(x,y);
            i++;
            contador = 0;
        } else if (KeyBoardInput.mexerPonto == false) {                    // JÁ TENHO OS 4 PONTOS INICIAIS E QUERO ADICIONAR MAIS PONTOS

            EventListener.TodosPontos[i] = new Point();
            TodosPontos[i].setX(x);
            i++;
            if (j == 0) {
                j++;
            }             
            EventListener.TodosPontos[i].setY(y);
            i++;
            if (j == 1) {
                j = 0;
                i++;
            }
            fazerPonto = true;
            contador = 1;
            EventListener.qtdPonto++;
            EventListener.Mais3Pontos++;

        } else { // ERSTOU PEGANDO O PONTO

            Point p;
            dragPoint = null;            
            
            for (int j = 0; j < i; j++) {
                p = (Point) TodosPontos[i];
                if (p.getX() == x && p.getY() == y) {
                    quePonto = j;
                    dragPoint = p;
                }

            }
        }

       
    }

    @Override
    public void mouseMoved (MouseEvent me) {

        x = me.getX();
        y = me.getY();
    }

    @Override
    public void mouseDragged (MouseEvent me) {
        
        if(KeyBoardInput.mexerPonto == true){
            
            dragPoint.setX(x); 
            dragPoint.setY(y);
        }   
        
    }

    @Override
    public void mouseWheelMoved (MouseEvent e){
        
        if(KeyBoardInput.mexerPonto == true){
            
            TodosPontos[quePonto] = dragPoint;
            
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
        
        
    }

}
