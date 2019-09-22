package bezier;

import static bezier.EventListener.TodosPontos;
import com.jogamp.nativewindow.util.Point;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.opengl.GLWindow;

public class MouseInput implements MouseListener {

    private int x;   // QUAL É A POSICAO X DO MOUSE
    private int y;   // QUAL É A POSICAO Y DO MOUSE
    private int quePonto = 0;  // QUE PONTO SO VETOR DE PONTOS EU VOU ARRASTAR
    public static boolean maisDe4Pontos = false;
    public static boolean criarCurva = false;
    public static int posAtual = 0;               // QUANTOS PONTOS EU TENHO NO VETOR DE PONTOS (TodosPontos) 
    public static boolean pegou = false;

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

        if (EventListener.qtdPonto == 0) {  // PRIMEIRO PONTO
           
            EventListener.qtdPonto = 1;
            EventListener.TodosPontos[posAtual] = new Point(x, y);
            posAtual++;           
            
        } else if (EventListener.qtdPonto == 1 && KeyBoardInput.mexerPonto == false) { // SEGUNDO PONTO
           
            EventListener.qtdPonto = 2;
            EventListener.TodosPontos[posAtual] = new Point(x, y);
            posAtual++;            

        } else if (EventListener.qtdPonto == 2 && KeyBoardInput.mexerPonto == false) { // TERCEIRO PONTO 
            
            EventListener.qtdPonto = 3;
            EventListener.TodosPontos[posAtual] = new Point(x, y);
            posAtual++;            

        } else if (EventListener.qtdPonto == 3 && KeyBoardInput.mexerPonto == false) { // QUARTO PONTO
           
            EventListener.qtdPonto = 4;
            EventListener.TodosPontos[posAtual] = new Point(x, y);
            posAtual++;            
            criarCurva = true; // PERMITE EU DESENHAR A CURVA
            
        } else if (KeyBoardInput.mexerPonto == false) {                    // JÁ TENHO OS 4 PONTOS INICIAIS E QUERO ADICIONAR MAIS PONTOS

            EventListener.TodosPontos[posAtual] = new Point(x,y);            
            posAtual++;
            criarCurva = true;  // SABER SE POSSO DESENHAR NA TELA A CURVA
            maisDe4Pontos = true;
            EventListener.qtdPonto++; // INCREMENTO QUANTOS PONTOS EU TENHO NA TELA
            EventListener.Mais3Pontos++; // FALTA 3 - 1 PONTOS PARA DESENHAR A PROXIMA CURVA

        } else { // ESTOU PEGANDO O PONTO PARA ARRASTAR
            Point p;
            if (pegou == false) {
                for (int j = 0; j < posAtual; j++) {
                    p = TodosPontos[j];                    

                    if ((p.getX() >= (x - 22) && p.getX() <= (x + 22)) && (p.getY() >= (y - 22) && p.getY() <= (y + 22))) {
                        pegou = true;
                        quePonto = j;  // QUE PONTO DO VETOR (TodosPontos) EU VOU ARRASTAR
                    }
                }
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
        x = me.getX();
        y = me.getY();
        
        if (KeyBoardInput.mexerPonto == true && pegou == true) {          
            
            TodosPontos[quePonto].setX(x); // ALTERO O X DO PONTO QUE EU PEGUEI COM AS COORDENADAS DO MOUSE
            TodosPontos[quePonto].setY(y);  // ALTERO O Y DO PONTO QUE EU PEGUEI COM AS COORDENADAS DO MOUSE
        }

    }

    @Override
    public void mouseDragged(MouseEvent me) {

    }

    @Override
    public void mouseWheelMoved(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }
}
