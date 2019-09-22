package bezier;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener {

    private Desenho curva1 = new Desenho(80, 10, 0, 80, 246, 100, 288, 30);

    private Desenho[] curvas = new Desenho[42];
    public static int qtdPonto = 0;
    public static double TodosPontos[][] = new double[40][2];
    private int queDesenho = 0;

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 1); // The Color who will apper when we clean the window
        // R,G,B,Alfa                Where 1 == 255 && 0 == 0 So, 0.11f == 30

    }

    @Override
    public void display(GLAutoDrawable drawable) {

        boolean plotar = MouseInput.fazerPonto;

        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glColor3d(1, 1, 1);// Takes RGB
        gl.glPointSize(5);

        if (qtdPonto == 1) {

            gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
            gl.glVertex2d(TodosPontos[0][0], TodosPontos[0][1]);
            gl.glEnd();
        } else if (qtdPonto == 2) {

            gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
            gl.glVertex2d(TodosPontos[0][0], TodosPontos[0][1]);
            gl.glVertex2d(TodosPontos[1][0], TodosPontos[1][1]);
            gl.glEnd();
        } else if (qtdPonto == 3) {

            gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
            gl.glVertex2d(TodosPontos[0][0], TodosPontos[0][1]);
            gl.glVertex2d(TodosPontos[1][0], TodosPontos[1][1]);
            gl.glVertex2d(TodosPontos[2][0], TodosPontos[2][1]);
            gl.glEnd();

        } else if (qtdPonto >= 4) {
            int c, l = 0;
            
            if (MouseInput.contador == 1) { // SEGUNDA E AS DEMAIS CURVAS

                if (MouseInput.fazerPonto == true) {
                    qtdPonto++;
                    queDesenho++;
                    System.out.println(qtdPonto);
                    curvas[queDesenho] = new Desenho(TodosPontos[qtdPonto - 3][0], TodosPontos[qtdPonto - 3][1],
                            TodosPontos[qtdPonto - 2][0], TodosPontos[qtdPonto - 2][1],
                            TodosPontos[qtdPonto - 1][0], TodosPontos[qtdPonto - 1][1],
                            TodosPontos[qtdPonto][0], TodosPontos[qtdPonto][1]);
                    curvas[queDesenho].setGl(gl);
                    curvas[queDesenho].Draw(60);
                    MouseInput.fazerPonto = false;
                }

                curvas[0].Draw(60);
                curvas[1].Draw(60);
                

                if (queDesenho == 2) {
                    for (l = 0; l < 1; l++) { // TENHO 3 CURVAS

                        curvas[l].Draw(60);
                        curvas[l + 1].Draw(60);
                        curvas[l + 2].Draw(60);
                    }
                }
                for (l = 0; l < MouseInput.i; l++) {
                    gl.glColor3d(1, 1, 1);// Takes RGB
                    gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
                    gl.glVertex2d(TodosPontos[l][0], TodosPontos[l][1]);
                    gl.glEnd();
                }

            } else {

                // PRIMEIRA CURVA A SER DESENHADA
                if (MouseInput.fazerPonto == true) {
                    curvas[queDesenho] = new Desenho(TodosPontos[0][0], TodosPontos[0][1], TodosPontos[1][0], TodosPontos[1][1], TodosPontos[2][0], TodosPontos[2][1], TodosPontos[3][0], TodosPontos[3][1]);
                    curvas[queDesenho].setGl(gl);
                    curvas[queDesenho].Draw(60);
                    MouseInput.fazerPonto = false;

                } else {
                    curvas[queDesenho].Draw(60);
                }
                for (l = 0; l < MouseInput.i; l++) {
                    gl.glColor3d(1, 1, 1);// Takes RGB
                    gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
                    gl.glVertex2d(TodosPontos[l][0], TodosPontos[l][1]);
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
