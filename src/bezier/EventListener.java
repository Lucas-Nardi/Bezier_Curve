package bezier;

import com.jogamp.nativewindow.util.Point;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener {

    public static Desenho[] curvas = new Desenho[40];  // VETOR QUE GUARDA TODAS AS CURVAS
    public static int qtdPonto = 0;                    // QUANTOS PONTO EU TENHO NA TELA
    public static Point TodosPontos[] = new Point[120]; // VETOR QUE GUARDA TODOS OS PONTOS QUE TEM NAS CURVAS
    public static int queDesenho = 0;                   // PEGA UMA CURVA DO VETOR DE CURVAS
    public static int Mais3Pontos = 0;                  // SABER QUANTOS PONTOS FALTAM PARA DESENHAR MAIS UMA CURVA

    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0, 0, 0, 1);    // COR DO BACKGROUD
    }

    @Override
    public void display(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glPointSize(5);

        if (qtdPonto < 4) {  // SO DESENHA OS PONTOS POIS< UMA CURVA PRECISA DE 4 PONTOS

            for (int i = 0; i < MouseInput.posAtual; i++) {  // EXIBIR OS PONTOS 1 2 E 3 NA TELA
                // PERCORRENDO O VETOR DE PONTOS
                gl.glColor3d(1, 1, 1);                // COR DO MEU PONTO                     
                gl.glBegin(GL2.GL_POINTS);
                gl.glVertex2d(TodosPontos[i].getX(), TodosPontos[i].getY());
                gl.glEnd();
            }

        } else if (qtdPonto == 4) {
            int l = 0;
            // PRIMEIRA CURVA A SER DESENHADA
            if (MouseInput.criarCurva == true) {  // PERMITE DESENHA FOR TRUE 
                curvas[queDesenho] = new Desenho(TodosPontos, MouseInput.posAtual);
                curvas[queDesenho].setGl(gl);
                curvas[queDesenho].Draw(100); // QUANTOS PONTO TEM EM CADA CURVA
                MouseInput.criarCurva = false;

            }
            curvas[queDesenho].Draw(100);  // DESENHA A PRIMEIRA CURVA
                                                  
            for (l = 0; l < MouseInput.posAtual; l++) {  // EXIBIR OS PONTOS DE CONTROLE DA CURVA 1
                gl.glColor3d(1, 1, 1);// Takes RGB
                gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
                gl.glVertex2d(TodosPontos[l].getX(), TodosPontos[l].getY());
                gl.glEnd();
            }

        } else if (qtdPonto > 4) {   // DESENHA A PRIMEIRA E AS DEMAIS CURVAS
            int l = 0;

            if (MouseInput.maisDe4Pontos) { // SEGUNDA E AS DEMAIS CURVAS

                if (MouseInput.criarCurva == true && Mais3Pontos == 3) { // POSSO DESENHAR MAIS UMA CURVA POIS TENHO MAIS 3 PONTOS

                    queDesenho++;                    
                    curvas[queDesenho] = new Desenho(TodosPontos, MouseInput.posAtual);
                    curvas[queDesenho].setGl(gl);
                    curvas[queDesenho].Draw(100);
                    MouseInput.criarCurva = false;
                    Mais3Pontos = 0;
                }
                // DESENHA TODAS AS CURVAS
                for (int i = 0; i <= queDesenho; i++) {
                    curvas[i].Draw(100);
                }

                // EXIBIR OS PONTOS DE CONTROLE
                for (l = 0; l < MouseInput.posAtual; l++) {
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
        gl.glOrtho(0, 640, 360, 0, -1, 1);  // Pense que sua tela tenha 4 quadrantes onde
        gl.glMatrixMode(GL2.GL_MODELVIEW);           // O eixo do x tenha -320 --> 0 e  0 --> 320
                                            // E o eixo y tenha -180 --> 0 e 0 --> 180
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {

    }
}
