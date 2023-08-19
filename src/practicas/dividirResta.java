package practicas;

public class dividirResta {

    public static int dividirRecur(int dividendo, int divisor){

        int resultado=0;

        //caso base
        if(dividendo<divisor){

            return resultado;

        }else{

            resultado++;
            dividirRecur(dividendo-divisor, divisor);
            return resultado;
        }

    }

    //metodo principal
    public static void main(String[] args) {

        dividirRecur(20,5);

    }
}


