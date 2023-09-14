package sistemaGestionEmpleados;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int accion=0;
        int opcionEmpleado=0;

        String nombre;
        int id;
        double sueldoBase;

        Scanner scanner = new Scanner(System.in);

        //creamos objeto Gestor empleados
        GestorEmpleados empleados = new GestorEmpleados();

        //mensaje de presentacion
        System.out.println("  \n\t\tBienvenido\n \n Esto es un gestor de empleados, que accion desea hacer?\n");


        while(accion != 5){

            System.out.println(" \n 1- Agregar empleado \n 2- Eliminar empleado \n 3- Modificar empleado \n 4- Buscar empleado \n 5- FINALIZAR PROGRAMA\n");

            System.out.print("eleccion: ");

            //excepcion para comprobar que esta ingresando un numero
            try {
                accion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nIngrese un valor numérico válido.\n");
                scanner.next(); // Limpia el búfer de entrada
            }

            //segun la opcion elegida, realizamos los diferentes metodos

            //metodo agregar empleado
            if(accion==1){

                System.out.println("\n*** agregar un empleado ***");


                    System.out.println("\nexisten 3 tipos de empleados:\n \n 1- Empleado por hora \n 2- Empleado asalariado \n 3- Empleado Comisionista \n\n ingrese que tipo de empleado quiere agregar.");
                    System.out.print("\n *eleccion: ");

                    try {
                    opcionEmpleado = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("\nIngrese un valor numérico válido.\n");
                        scanner.next(); // Limpia el búfer de entrada
                    }

                

                //segun que tipo de empleado desea cargar el usuario se realizan diferentes bloques de codigo, ya que son objetos distintos.

                //Empleado por hora
                if(opcionEmpleado==1){

                    int horasTrabajadas;

                    System.out.println("\n*** Empleado por hora ***\n");

                    System.out.print("1- ingrese su ID: ");
                    id=scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("2- ingrese su Nombre: ");
                    nombre=scanner.nextLine();
                    System.out.print("3- ingrese las horas trabajadas:");
                    horasTrabajadas=scanner.nextInt();

                    
                    System.out.print("4- ingrese el sueldo base: $");
                    sueldoBase=scanner.nextDouble();

                    EmpleadoPorHora empleadoPorHora = new EmpleadoPorHora(nombre, id, horasTrabajadas, sueldoBase);

                    empleados.agregarEmpleado(empleadoPorHora);

                    System.out.println("\n*** Empleado cargado exitosamente ***");
                    System.out.println(empleadoPorHora);


                }
                //Empleado Asalariado
                else if(opcionEmpleado==2){

                    System.out.println("\n*** Empleado asalariado ***\n");

                    System.out.print("1- ingrese su ID: ");
                    id=scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("2- ingrese su Nombre: ");
                    nombre=scanner.nextLine();
                    System.out.print("4- ingrese el sueldo base: $");
                    sueldoBase=scanner.nextDouble();

                    EmpleadoAsalariado empleadoAsalariado = new EmpleadoAsalariado(nombre, id, sueldoBase);

                    empleados.agregarEmpleado(empleadoAsalariado);

                    System.out.println("\n*** Empleado cargado exitosamente ***");
                    System.out.println(empleadoAsalariado);

                }
                //Empleado comisionista
                else if(opcionEmpleado==3){

                    double ventasRealizadas;

                    System.out.println("\n*** Empleado comisionista ***\n");

                    System.out.print("1- ingrese su ID: ");
                    id=scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("2- ingrese su Nombre: ");
                    nombre=scanner.nextLine();
                    System.out.print("3- ingrese el sueldo base:");
                    sueldoBase=scanner.nextDouble();
                    System.out.print("4- ingrese el monto de las ventas realizadas: $");
                    ventasRealizadas=scanner.nextDouble();

                    EmpleadoComision empleadoComision = new EmpleadoComision(nombre, id, ventasRealizadas, sueldoBase);

                    empleados.agregarEmpleado(empleadoComision);

                    System.out.println("\n*** Empleado cargado exitosamente ***");
                    System.out.println(empleadoComision);


                }else{
                    System.out.println("\t\t NUMERO ELEGIDO FUERA DE RANGO");
                }

            }
            //metodo eliminar un empleado
            else if(accion==2){

                System.out.println("\n*** eliminar un empleado ***\n");

                System.out.println("ingrese el ID del empleado que desea eliminar: ");
                id=scanner.nextInt();

                empleados.eliminarEmpleado(id);
                
                System.out.println("\n*** Empleado eliminado exitosamente ***");

            }
            //metodo modificar un empleado
            else if(accion==3){

                System.out.println("\n*** modificar un empleado ***\n");
                
                System.out.println("-ingrese el ID del empleado que desea modificar:");
                id=scanner.nextInt();
                scanner.next();
                System.out.println("-ingrese su nuevo nombre:");
                nombre=scanner.nextLine();
                System.out.println("-ingrese su nuevo sueldo base:");
                sueldoBase=scanner.nextDouble();
                
                empleados.editarEmpleado(id, nombre, sueldoBase);

                System.out.println("\n*** Empleado editado exitosamente ***");

            }else if(accion==4){

                System.out.println("ingrese el ID del empleado que desea buscar: ");
                id=scanner.nextInt();
                empleados.buscarEmpleado(id);        

            }else if(accion==5){

                System.out.println("\n\t\tPROGRAMA FINALIZADO");  
                empleados.returnGestorEmpleados();            

            }else{
                System.out.println("\n\t\t CARACTER ELEGIDO FUERA DE RANGO");
            }

            System.out.println(" ");

        }
    




            
        }


}
