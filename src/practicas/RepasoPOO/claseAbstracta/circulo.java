//package practicas.RepasoPOO.claseAbstracta;

public class circulo extends figura{

    double radio;

    public circulo(double radio){
        this.radio=radio;
    }

    @Override
    public double calcularArea(){
        return Math.PI*radio*radio;
    }
    
}
