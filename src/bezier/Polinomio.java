package bezier;

public class Polinomio {
    
    public double CriarPonto(double p0, double p1,double p2,double p3,double t){
        
        double resultado = Math.pow((1-t), 3) * p0 + (3*t) * Math.pow((1-t), 2) * p1 + (3 * Math.pow(t, 2)) *(1-t)* p2 + Math.pow(t, 3)*p3;
        return resultado;
    }
}
