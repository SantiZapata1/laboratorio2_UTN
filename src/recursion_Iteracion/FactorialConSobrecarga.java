package recursion_Iteracion;

/*Factorial con Sobrecarga (Recursión e Iteración)
Crea un programa que calcule el factorial de un número utilizando dos métodos diferentes: uno utilizando recursión y otro utilizando iteración. Estos métodos deben estar en una clase distinta. Emplea la sobrecarga de métodos para diferenciar entre las dos implementaciones. Realiza pruebas del programa con distintos números enteros.
 */

public class FactorialConSobrecarga {

    //metodo iterativo
    public static int factorialItertivo(int numero,int inicio){//usamos sobracarga de metodos

        int factorial=1;

        //El metodo iteratiro va multiplicando desde el 1 hasta n, con lo que va acumulando la variable factorial
        while(inicio<numero){
            factorial=factorial*(inicio+1);
            inicio++;
        }

        return factorial;
    }

    //metodo recursivo
    public static double factorialRecursivo(double numero){

        double factorial=1;

        //En el metodo recursivo, los productos se hacen desde n hasta el 1, llamandose a si misma para hacerlo de forma recursiva
        if(numero<=1){
            return factorial;
        }else{
            factorial=numero*factorialRecursivo(numero-1);
            return factorial;
        }

    }
    
    //procedimiento principal
    public static void main (String[] args){

        //pruebas de los diferentes metodos
        int resultado=factorialItertivo(5,1);
        System.out.println("resultado n! iterativo: "+resultado);

        double resultado2=factorialRecursivo(7);
        System.out.println("resultado n! recursivo: "+resultado2);

    }


}
