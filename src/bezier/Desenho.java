package bezier;

import com.jogamp.nativewindow.util.Point;
import com.jogamp.opengl.GL2;

public class Desenho {

    private Point ctrlP[];
    private GL2 gl;
    private Polinomio poly;
    private int quaisPontos;  // SABER QUAIS PONTOS EU PRECISO PARA DESENHAR A CURVA

    public Desenho(Point[] PontosDeControle ,int  quaisPontos) {
        this.ctrlP = PontosDeControle;
        poly = new Polinomio();
        this.quaisPontos = quaisPontos;
    }
    public GL2 getGl() {
        return gl;
    }

    public void setGl(GL2 gl) {
        this.gl = gl;
    }

    public void Draw(double qtdPontos) {

        double t, t1;
        double px1, py1, px2, py2;
        int p = (quaisPontos -4 );        
        double x1,y1,x2,y2,x3,y3,x4,y4;
         // PONTOS DE CONTROLE
        x1 = ctrlP[p].getX();       
        y1 = ctrlP[p].getY();        
        x2 = ctrlP[p+1].getX();        
        y2 = ctrlP[p+1].getY();         
        x3 = ctrlP[p+2].getX();         
        y3 = ctrlP[p+2].getY();     
        x4 = ctrlP[p+3].getX();        
        y4 = ctrlP[p+3].getY();
        
        
        
        for (int i = 0; i < qtdPontos - 1; i++) {
            gl.glColor3d(1, 1, 0);                    // QUAL É A COR DA CURVA
            gl.glLineWidth(3);                        // GROSSURA DA LINHA
            t = i / qtdPontos;
            t1 = (i + 1) / qtdPontos;
            
            
            px1 = poly.CriarPonto(x1, x2 , x3, x4, t);            
            py1 = poly.CriarPonto(y1, y2, y3, y4, t);
            px2 = poly.CriarPonto(x1, x2, x3, x4, t1);
            py2 = poly.CriarPonto(y1, y2, y3, y4, t1);
            gl.glBegin(GL2.GL_LINES); // Começa a desemnhas quadrilateros
            gl.glVertex2d(px1, py1);
            gl.glVertex2d(px2, py2);
            gl.glEnd();
        }
    }

    public int getQuaisPontos() {
        return quaisPontos;
    }

    public void setQuaisPontos(int quaisPontos) {
        this.quaisPontos = quaisPontos;
    }
    
    public Polinomio getPoly() {
        return poly;
    }

    public void setPoly(Polinomio poly) {
        this.poly = poly;
    }

}
