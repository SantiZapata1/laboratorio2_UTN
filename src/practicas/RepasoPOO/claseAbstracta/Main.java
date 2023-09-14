//package practicas.RepasoPOO.claseAbstracta;

public class Main {
    public static void main(String[] args) {

        cuadrado cua1 = new cuadrado(19);
        circulo cir1 = new circulo(6);

        System.out.println(cir1.calcularArea());
        System.out.println(cua1.calcularArea());
        
    }
    
}
