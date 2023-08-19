package recursion_Iteracion;

/*Desarrolla un programa que realice la división de dos números enteros utilizando tanto el enfoque recursivo como el iterativo con restas sucesivas. Implementa ambos enfoques en la misma clase, utilizando la sobrecarga de métodos para diferenciarlos. Luego, realiza pruebas utilizando distintos pares de números. */

public class DivisionConResta {

    //metodo iterativo
    public static int DivisionIterativa(int dividendo, int divisor){

        int cociente=0;

        //mientras el dividendo sea mayor o igual al divisor, se realizan restas sucesivas intrementando el cociente
        while(dividendo>=divisor){
            dividendo=dividendo-divisor;
            cociente++;
        }
        return cociente;
    }

    //metodo recursivo
    public static float DivisionRecursiva(double d, double e){

        float cociente=0;

        //caso base
        if(d<e){
            return cociente;
        //mientras el dividendo dea mayor, se aplica la funcion de forma recursiva y se incrementa el cociente
        }else{
            cociente = DivisionRecursiva(d-e, e);
            return cociente+1;
        }

    }


    //procedimiento principal
    public static void main(String[] args) {

        //pruebas de los diferentes metodos
        int resultado=DivisionIterativa(23,2);
        System.out.println("resultado iterativo: "+resultado);

        double resultado2=DivisionRecursiva(27.0,2.0);
        System.out.println("resultado recursivo: "+resultado2);

    }
    
    
}
