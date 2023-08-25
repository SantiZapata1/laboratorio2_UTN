//package practicas.arrayList.colecciones;

import java.util.ArrayList;

public class practica {

    public static void main(String[] args) {
        // Crear un ArrayList de cadenas
        ArrayList<String> nombres = new ArrayList<>();

        // Agregar elementos al ArrayList
        nombres.add("Alice");
        nombres.add("Bob");
        nombres.add("Charlie");

        // Acceder a elementos por índice
        String primerNombre = nombres.get(0);
        System.out.println("Primer nombre: " + primerNombre);

        // Iterar a través del ArrayList
        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }
}

    

