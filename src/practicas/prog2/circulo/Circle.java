//package practicas.prog2.circulo;

//ejercicios https://github.com/progii-tsp-frre-utn/2021/blob/main/Practica/Ejercicios%20-%20Avanzados%20OOP.pdf

public class Circle {

    //atributos
    double radius2;

    public static final double radius = 42;

    //constructores
    public Circle(){
        this.radius2=radius;
    }
    public Circle(double radius){
        this.radius2=radius;
    }

    //metodos
    public void setRadius(double radius){
        this.radius2=radius;
    }
    public double getRadius(){
        return radius2;
    }
    public double getCircunsference(){
        return 2*Math.PI*radius2;
    }
    public double getArea(){
        return Math.PI*radius2*radius2;
    }

    @Override
    public String toString(){

        return "circle["+radius2+"]";

    }








    
}
