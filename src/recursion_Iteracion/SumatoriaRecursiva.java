package recursion_Iteracion;//en visual tengo que comentar esta linea para que funcione

/*Escribe un programa que calcule la sumatoria de los números enteros desde 1 hasta un número dado utilizando una función recursiva. Implementa esta funcionalidad en una clase separada. Asegúrate de probar la función con diferentes valores de entrada. */

public class SumatoriaRecursiva {

    //metodo recursivo
    public static int sumatoria(int numero,int inicio) {

        int acumulador=0;

        //Se toma el limite inferior y superior y se van acumulado la suma de forma recursiva de los numeros que se encuentran entre ellos.
        if(inicio>numero){
            return acumulador;
        }else{
            acumulador=inicio+sumatoria(numero,inicio+1);
            return acumulador;
        }
    }


    public static void main(String[] args) {
        
        //pruebas del metodo
        int resultado=sumatoria(10,1);
        System.out.println("resultado sumatoria resursiva: "+resultado);
        resultado=sumatoria(15,1);
        System.out.println("resultado sumatoria resursiva 2: "+resultado);
    }
    
}
