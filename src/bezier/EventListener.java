package bezier;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class EventListener implements GLEventListener{

    
    public Desenho curva1 = new Desenho(80,10,0,80,246,100,288,30);
    public Desenho curva2 = new Desenho(40,10,0,80,123,100,144,30);
    private Desenho curva3;
    public boolean mirroring = false;
    public static double x1;    //  PONTO DE CONTROLE 1 (x1,y1)
    public static double y1;    //-------------------------------
    public static double x2;    //  PONTO DE CONTROLE 2 (x2,y2)
    public static double y2;    //-------------------------------
    public static double x3;    //  PONTO DE CONTROLE 3 (x3,y3)
    public static double y3;    // ------------------------------
    public static double x4;    // PONTO DE CONTROLE 4 (x4,y4)
    public static double y4;    // -------------------------------
    
       
    @Override
    public void init(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(0.98f, 0.73f, 0.11f, 1); // The Color who will apper when we clean the window
        // R,G,B,Alfa                Where 1 == 255 && 0 == 0 So, 0.11f == 30
       
    }

    @Override
    public void display(GLAutoDrawable drawable) {
      
        boolean plotar = MouseInput.fazerPonto;
        
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
        gl.glColor3d(0.64d, 0.16d, 0.16d);// Takes RGB
        gl.glPointSize(30);        
        curva1.setGl(gl);        
        curva1.Draw(100);
//        if(mirroring == false){
//            curva2.ReflexaoEixoX();
//            mirroring = true;
//        }        
//        curva2.setGl(gl);
//        curva2.Draw(100);
        if(MouseInput.contador == 1){
           gl.glColor3d(0.85d, 0.44d, 0.16d);// Takes RGB
           gl.glBegin(GL2.GL_POINTS); // Começa a desemnhas quadrilateros
                gl.glVertex2d(x1, y1);                         
            gl.glEnd(); 
        }else if(MouseInput.contador == 2){
            gl.glBegin(GL2.GL_LINES); // Começa a desemnhas quadrilateros
                gl.glVertex2d(x1, y1);
                gl.glVertex2d(x2, y2);
            gl.glEnd(); 
        }else if(MouseInput.contador == 3){
            gl.glBegin(GL2.GL_LINES); // Começa a desemnhas quadrilateros
                gl.glVertex2d(x1, y1);
                gl.glVertex2d(x2, y2);
            gl.glEnd(); 
        }else if(MouseInput.contador >= 4){
            gl.glBegin(GL2.GL_LINES); // Começa a desemnhas quadrilateros
                gl.glVertex2d(x1, y1);
                gl.glVertex2d(x2, y2);
            gl.glEnd(); 
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
