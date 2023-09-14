//package practicas.excepciones;

public class ejemplo {

    public static void main(String[] args) {
        try {
            int resultado = dividir(10, 0);
            System.out.println("Resultado: " + resultado);
        } catch (MiExcepcionPersonalizada e) {
            System.out.println("Error personalizado: " + e.getMessage());
        }
    }

    public static int dividir(int numerador, int denominador) throws MiExcepcionPersonalizada {
        if (denominador == 0) {
            throw new MiExcepcionPersonalizada("División por cero no permitida");
        }
        return numerador / denominador;
    }
}

class MiExcepcionPersonalizada extends Exception {

    public MiExcepcionPersonalizada(){
        
    }

    public MiExcepcionPersonalizada(String mensaje) {
        super(mensaje);
    }
}
