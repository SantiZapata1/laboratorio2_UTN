import java.util.ArrayList;
import java.util.Scanner;

public class practica {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(5);
        numeros.add(3);

        System.out.println(" ");
        System.out.println("Contenido inicial del ArrayList: " + numeros);

        System.out.print("Desea ingresar numeros al ArrayList? si/no:  ");
        String respuesta = scanner.nextLine();

        if (respuesta.equals("si")) {

            System.out.print("¿Cuantos numeros desea ingresar? ");
            int cantidad = scanner.nextInt();

            cargarArray(cantidad, numeros);
            System.out.println("Contenido posterior del ArrayList: " + numeros);
        } else {
            System.out.println("Ok, no se agregarán números al arrayList ");
        }

    }

    //procedimiento para cargar arrayList
    public static void cargarArray(int cantidad, ArrayList<Integer> numeros) {
        int lectura;

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            lectura = scanner.nextInt();
            numeros.add(lectura);
        }
    }
}


