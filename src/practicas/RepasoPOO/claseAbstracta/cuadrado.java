//package practicas.RepasoPOO.claseAbstracta;

public class cuadrado extends figura{

    double lado;

    public cuadrado(double lado){
        this.lado=lado;
    }

    @Override
    public double calcularArea(){
        return lado*lado;
    }

}
