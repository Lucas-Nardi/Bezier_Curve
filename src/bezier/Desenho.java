package bezier;

import com.jogamp.opengl.GL2;

public class Desenho {

    private double x1;    //  PONTO DE CONTROLE 1 (x1,y1)
    private double y1;    //-------------------------------
    private double x2;    //  PONTO DE CONTROLE 2 (x2,y2)
    private double y2;    //-------------------------------
    private double x3;    //  PONTO DE CONTROLE 3 (x3,y3)
    private double y3;    // ------------------------------
    private double x4;    // PONTO DE CONTROLE 4 (x4,y4)
    private double y4;    // -------------------------------
    GL2 gl;
    Polinomio poly;

    public Desenho(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;        
        poly = new Polinomio();
    }

    public GL2 getGl() {
        return gl;
    }

    public void setGl(GL2 gl) {
        this.gl = gl;
    }

    public void Draw(double qtdPontos) {
        
        double t,t1;
        double px1,py1,px2,py2;
        
        for (double i = 0; i < qtdPontos - 1; i++) {
            gl.glLineWidth(2);
            t = i / qtdPontos;
            t1 = (i + 1) / qtdPontos;
            px1 = poly.CriarPonto(x1,x2,x3,x4, t);
            py1 = poly.CriarPonto(y1,y2,y3,y4, t);
            px2 = poly.CriarPonto(x1,x2,x3,x4, t1);
            py2 = poly.CriarPonto(y1,y2,y3,y4, t1);            
            gl.glBegin(GL2.GL_LINES); // Começa a desemnhas quadrilateros
                gl.glVertex2d(px1, py1);
                gl.glVertex2d(px2, py2);            
            gl.glEnd();
        }
    }
    public void ReflexaoEixoX(){
        this.y1 = -y1;
        this.y2 = -y2;
        this.y3 = -y3;
        this.y4 = -y4;
    }
    public void ReflexaoEixoY(){
        this.x1 = -x1;
        this.x2 = -x2;
        this.x3 = -x3;
        this.x4 = -x4;
    }
    public void Escalonar(double width, double height){
        
        double pontoZeroX;
        double pontoZeroY;
        pontoZeroX = x1;        
        pontoZeroY = y1;
        this.x1 = (-x1); // PONTO 1 ESTVA NO ZERO ZERO
        this.y1 = (-y1);
        
        
        
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;   
    }
}
