package Parcial1Java;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//main
public class Hospital implements Serializable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        crearArchivo("archivo.dat");


        ArrayList<Doctor> arrayListDoctores = new ArrayList<>();

        Doctor doctor1 = new Doctor("santi", 20, "10/10/2003","cardiologia");
        Doctor doctor2 = new Doctor("lucas",30,"20/01/1999","fisioterapia");
        Doctor doctor3 = new Doctor("juan",50,"10/20/1970","neurologia");

        arrayListDoctores.add(doctor1);
        arrayListDoctores.add(doctor2);
        arrayListDoctores.add(doctor3);

        ArrayList<Paciente> arrayListPacientes = new ArrayList<>();

        Paciente paciente1 = new Paciente("pedro",20, "10/10/2003", 12313123,2);
        Paciente paciente2 = new Paciente("agus",19, "5/02/1990", 324432423,1);
        Paciente paciente3 = new Paciente("lautaro",40, "01/10/1980", 876778,3);

        arrayListPacientes.add(paciente1);
        arrayListPacientes.add(paciente2);
        arrayListPacientes.add(paciente3);

        String mensajeBienvenida="Hospital Julio C. Perrando - Av. 9 de Julio 1100 · 0362 444-2399\nMenú:";
        System.out.println(mensajeBienvenida);



         int cont=0;
        
                while(true){
        
                    cont+=1;
                    System.out.println("\n --------------- accion numero "+cont+" ---------------");
        
                     System.out.println("1. Listar doctores ");
                     System.out.println("2. Registrar un nuevo paciente ");
                     System.out.println("3. Actualizar informacion personal de un paciente ");
                     System.out.println("4. Consultar el historial medico de un paciente ");
                     System.out.println("5. Nuevo historial para un paciente ");
                     System.out.println("6. Guardar historial de pacientes en archivo ");
                     System.out.println("7. Cargar historial de pacientes en archivo ");
                     System.out.println("8. Salir ");

        
                     System.out.print("\nIngrese su opción: ");
                     int opcion = scanner.nextInt();
        
                    switch (opcion) {
        
                         case 1:
                             System.out.println("\n1. Listar doctores: ");

                             listarDoctores(arrayListDoctores);

                             break;
                         case 2:
                             System.out.println("2. Registrar un nuevo paciente ");

                             System.out.print("ingrese el nombre del nuevo paciente:");
                             String nombre = scanner.next();
                             System.out.print("ingrese el dni del nuevo paciente:");
                             int dni = scanner.nextInt();
                             System.out.print("ingrese la fecha de nac del nuevo paciente");
                             String fechaNacimiento = scanner.next();
                             System.out.print("ingrese numero de telefono del nuevo paciente:");
                             int numTelefono = scanner.nextInt();
                             System.out.print("ingrese tipo de sangre del nuevo paciente:");
                             int tipoSangre = scanner.nextInt();

                             Paciente nuevoPaciente = new Paciente(nombre,dni,fechaNacimiento,numTelefono,tipoSangre);

                             arrayListPacientes.add(nuevoPaciente);
                             System.out.println("\npaciente agregado con exito");
                             System.out.println(nuevoPaciente);

                             break;
                         case 3:
                             System.out.println("3. Actualizar informacion personal de un paciente ");


                             System.out.print("ingrese el dni del paciente que quiere actualizar:");
                             int dni3 = scanner.nextInt();

                             for (Paciente paciente : arrayListPacientes) {
                                 if (paciente.getDni()==dni3) {

                                     System.out.println("paciente encontrado");
                                     
                                     System.out.print("ingrese nuevo telefono:");
                                     int telefono = scanner.nextInt();
                                     paciente.setNroTelefono(telefono);
                                     System.out.print("ingrese nuevo tipo de sangre:");
                                     int tipoSangre1 = scanner.nextInt();
                                     paciente.setTipoSangre(tipoSangre1);

                                     System.out.println("paciente editado corectamente");

                                 }
                             }
        
                             break;
                         case 4:
                             System.out.println("4. Consultar el historial medico de un paciente ");
                             System.out.print("ingrese el dni del paciente que quiere consultar:");
                             int dni2 = scanner.nextInt();

                             for (Paciente paciente : arrayListPacientes) {
                                 if (paciente.getDni()==dni2) {

                                     System.out.println("paciente encontrado");
                                     System.out.println("historial medico:");

                                     System.out.println(paciente.verHistorialEventos());

                                 }
                             }
                             break;
                         case 5:
                             System.out.println("5. Nuevo historial para un paciente ");

                             System.out.print("ingrese el dni del paciente a agregar historial:");
                             int dni1 = scanner.nextInt();

                             for (Paciente paciente : arrayListPacientes) {
                                 if (paciente.getDni()==dni1) {

                                     System.out.println("paciente encontrado");
                                     System.out.print("ingrese historial:");
                                     String historial = scanner.next();

                                     paciente.agregarHistorial(historial);
                                     System.out.println("historial agregado");

                                 }
                             }


        
                             break;
                         case 6:
                             System.out.println("6. Guardar historial de pacientes en archivo ");

                             serializarArrayList(arrayListPacientes, "archivo.dat");

                             break;
                        case 7:
                            System.out.println("6. Cargar historial de pacientes en archivo ");
                            ArrayList<Paciente> listaDeserializada = deserializarArrayList("archivo.dat");


                            break;
                        case 8:
                            System.out.println("programa finalizado  ");

                            return;
                         default:
                             System.out.println("ingrese un caracer valido");
        
                     }
                }










    }

    //actividad1: metodo para listar doctores
    public static void listarDoctores( ArrayList<Doctor> arrayListDoctores){
        int cont=0;
        for (Doctor doctor: arrayListDoctores) {
            cont+=1;
            System.out.println(cont+" - "+doctor.toString());
        }
    }

    //actividad 2: metodo para agregar paciente
    public static void agregarPaciente(Paciente paciente, ArrayList<Paciente> arrayListPaciente){
        arrayListPaciente.add(paciente);
        System.out.println("paciente agregado");
        System.out.println(paciente.toString());
    }

    // Método para serializar un ArrayList
    public static void serializarArrayList(ArrayList<Paciente> lista, String nombreArchivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            outputStream.writeObject(lista);
            System.out.println("ArrayList serializado y guardado en " + nombreArchivo + " correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el ArrayList en " + nombreArchivo + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static ArrayList<Paciente> deserializarArrayList(String nombreArchivo) {
        ArrayList<Paciente> listaDeserializada = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            listaDeserializada = (ArrayList<Paciente>) inputStream.readObject();
            System.out.println("ArrayList deserializado correctamente desde " + nombreArchivo + ".");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar el ArrayList desde " + nombreArchivo + ": " + e.getMessage());
            e.printStackTrace();
        }
        return listaDeserializada;
    }
    public static void crearArchivo(String nombreArchivo){

        File archivo = new File(nombreArchivo);

        try {
            if (archivo.createNewFile()) {
                System.out.println("El archivo se ha creado correctamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }

    }




}

//superclase persona, la hacemos abstracta?
abstract class Persona implements Serializable {

    //atributos
     String nombre;
     int dni;
     String fechaNacimiento;

    //constructores
    public Persona(String nombre, int dni, String fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }
    public Persona() {
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //metodos
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni=" + dni +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }

}

class Doctor extends Persona implements Serializable{

    //atributos
    private String especialidad;

    //contructores
    public Doctor(String nombre, int dni, String fechaNacimiento, String especialidad) {
        super(nombre, dni, fechaNacimiento);
        this.especialidad = especialidad;
    }
    public Doctor() {
    }

    //getters y setters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    //metodos
    @Override
    public String toString() {
        return "Doctor{" +
                "especialidad='" + especialidad + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni=" + dni +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }

}

//interfaz para ver historial de eventos
interface Informacion{
    String verHistorialEventos();
}

class Paciente extends Persona implements Informacion, Serializable{

    Scanner scanner = new Scanner(System.in);


    //atributos
     int nroTelefono;
     int tipoSangre;
     ArrayList<String> arrayListHistorial = new ArrayList<>();


     //constructores
    public Paciente(String nombre, int dni, String fechaNacimiento, int nroTelefono, int tipoSangre) {
        super(nombre, dni, fechaNacimiento);
        this.nroTelefono = nroTelefono;
        this.tipoSangre = tipoSangre;
        ArrayList<String> arrayListHistorial=new ArrayList<>();
    }
    public Paciente() {
    }


    //getters y setters
    public int getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(int nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public int getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(int tipoSangre) {
        this.tipoSangre = tipoSangre;
    }


    //metodos
    @Override
    public String verHistorialEventos() {
        String lista=" ";

        for (String historial : arrayListHistorial) {
            lista += historial;
        }
        return lista;

    }


    @Override
    public String toString() {
        return "Paciente{" +
                "nombre="+ nombre +
                ", dni="+dni+
                ", nacimiento="+fechaNacimiento+
                ", nroTelefono=" + nroTelefono +
                ", tipoSangre=" + tipoSangre +
                ", HistorialMedico=" + arrayListHistorial +
                '}';
    }


    public void agregarHistorial(String historialNuevo){

        arrayListHistorial.add(historialNuevo);

    }

}


