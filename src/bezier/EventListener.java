package bezier;

import com.jogamp.nativewindow.util.Point;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener {

    private Desenho curva1 = new Desenho(80, 10, 0, 80, 246, 100, 288, 30);

    private Desenho[] curvas = new Desenho[42];
    public static int qtdPonto = 0;
    public static Point TodosPontos[] = new Point[42];
    private int queDesenho = 0;
    public static int Mais3Pontos = 0;
    
    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 1); // The Color who will apper when we clean the window
        // R,G,B,Alfa                Where 1 == 255 && 0 == 0 So, 0.11f == 30

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glColor3d(1, 1, 1);// Takes RGB
        gl.glPointSize(5);

        if (qtdPonto == 1) { // DESENHA OS 3 PRIMEIROS PONTOS

            gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
            gl.glVertex2d(TodosPontos[0].getX(), TodosPontos[0].getY());
            gl.glEnd();
        } else if (qtdPonto == 2) {

            gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
            gl.glVertex2d(TodosPontos[0].getX(), TodosPontos[0].getY());
            gl.glVertex2d(TodosPontos[1].getX(), TodosPontos[1].getY());
            gl.glEnd();
        } else if (qtdPonto == 3) {

            gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
            gl.glVertex2d(TodosPontos[0].getX(), TodosPontos[0].getY());
            gl.glVertex2d(TodosPontos[1].getX(), TodosPontos[1].getY());
            gl.glVertex2d(TodosPontos[2].getX(), TodosPontos[0].getY());
            gl.glEnd();

        } else if (qtdPonto >= 4) {   // DESENHA A PRIMEIRA E AS DEMAIS CURVAS
            int l = 0;
            
            
            if (MouseInput.contador == 1) { // SEGUNDA E AS DEMAIS CURVAS

                if (MouseInput.fazerPonto == true &&  Mais3Pontos == 3) {
                    
                    queDesenho++;
                    System.out.println(qtdPonto);
                    curvas[queDesenho] = new Desenho(TodosPontos[qtdPonto - 4].getX(), TodosPontos[qtdPonto - 4].getY(),
                                                        TodosPontos[qtdPonto - 3].getX(), TodosPontos[qtdPonto - 3].getY(),
                                                        TodosPontos[qtdPonto - 2].getX(), TodosPontos[qtdPonto - 2].getY(),
                                                        TodosPontos[qtdPonto - 1].getX(), TodosPontos[qtdPonto - 1].getY());
                    curvas[queDesenho].setGl(gl);
                    curvas[queDesenho].Draw(100);
                    MouseInput.fazerPonto = false;
                    Mais3Pontos = 0;
                }
                // DESENHA TODAS AS CURVAS
               for(int i=0; i <= queDesenho ; i ++){
                   curvas[i].Draw(100);
               }
                

                // EXIBIR OS PONTOS DE CONTROLE
                for (l = 0; l < MouseInput.i; l++) {
                    gl.glColor3d(1, 1, 1);// Takes RGB
                    gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
                    gl.glVertex2d(TodosPontos[l].getX(), TodosPontos[l].getY());
                    gl.glEnd();
                }

            } else if (qtdPonto == 4) {

                // PRIMEIRA CURVA A SER DESENHADA
                if (MouseInput.fazerPonto == true) {
                    curvas[queDesenho] = new Desenho(TodosPontos[0].getX(), TodosPontos[0].getY(),
                                                        TodosPontos[1].getX(), TodosPontos[1].getY(),
                                                        TodosPontos[2].getX(), TodosPontos[2].getY(),
                                                        TodosPontos[3].getX(), TodosPontos[3].getY());
                    curvas[queDesenho].setGl(gl);
                    curvas[queDesenho].Draw(100);
                    MouseInput.fazerPonto = false;

                } else { // DESENHA A CURVA 
                    curvas[queDesenho].Draw(100);
                }                                         // EXIBIR OS PONTOS DE CONTROLE
                for (l = 0; l < MouseInput.i; l++) {
                    gl.glColor3d(1, 1, 1);// Takes RGB
                    gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
                    gl.glVertex2d(TodosPontos[l].getX(), TodosPontos[l].getY());
                    gl.glEnd();
                }

            }else{
                for (l = 0; l < MouseInput.i; l++) {
                    gl.glColor3d(1, 1, 1);// Takes RGB
                    gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
                    gl.glVertex2d(TodosPontos[l].getX(), TodosPontos[l].getY());
                    gl.glEnd();
                }
            }
        }
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {  // MODO DE AJUSTE DE TELA

        GL2 gl = drawable.getGL().getGL2();
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        //float unitsTall = OpenGL_Aplication.getWindowHeight()/(OpenGL_Aplication.getWindowWidth()/OpenGL_Aplication.unitWide);
        gl.glOrtho(0, 640, 0, 360, -1, 1); // Pense que sua tela tenha 4 quadrantes onde
        gl.glMatrixMode(GL2.GL_MODELVIEW);           // O eixo do x tenha -320 --> 0 e  0 --> 320
        // E o eixo y tenha -180 --> 0 e 0 --> 180
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {

    }
}
