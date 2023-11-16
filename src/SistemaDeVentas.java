package Parcial2Lab.OFICIAL;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SistemaDeVentas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Comerciales comercio = new Comerciales();

        Vendedor vendedor1 = new Vendedor("santi","zapata",45044392,"2003-10-15","2020-10-10");
        Vendedor vendedor2 = new Vendedor("SELECT * FROM `vendedores` WHERE `vendedor_id` = 3");

        //punto 3
        System.out.println("\n-----------------punto 3:");
        System.out.println(vendedor1);
        System.out.println(vendedor2);

        //punto 4
        System.out.println("\n-----------------punto 4:");
        System.out.println(comercio.obtenerVendedorPorID(2));

        //punto 5
        System.out.println("\n-----------------punto 5:");
        comercio.generarInforme();

        //punto 6
        System.out.println("\n-----------------punto 6:");
        System.out.println("\n"+Producto.obtenerProducto(9));

        //punto 7
        System.out.println("\n-----------------punto 7:");
        System.out.println("\n"+Producto.obtenerProductoMasVendido());

        //punto 8
        System.out.println("\n-----------------punto 8:");
        ArrayList vendedores = new ArrayList<>();
        vendedores=comercio.listadoDeVendedores();
        System.out.println(vendedores);

    }

}

//clase comerciales
class Comerciales{

    public  Vendedor obtenerVendedorPorID(int vendedorID) {

        String consulta = "SELECT * FROM vendedores WHERE vendedor_id = '"+vendedorID+"'";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);

        try {
            if(resultado.next()){
                int id = resultado.getInt("vendedor_id");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                int dni = resultado.getInt("dni");
                String fechaNacimiento = resultado.getString("fecha_nacimiento");
                String fechaContratacion = resultado.getString("fecha_contratacion");

                Vendedor vendedor = new Vendedor(id,nombre,apellido,dni,fechaNacimiento,fechaContratacion);
                return vendedor;
            }else {
                System.out.println("no existe ese vendedor");
                return null;

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void generarInforme(){

        String consulta = "SELECT * FROM productos";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);

        double acumulacion=0;

        if (resultado != null) {
            try {
                System.out.println("\nInforme de Productos en Stock:");

                System.out.printf("%-25s %-15s %-20s %-20s\n", "producto", "stock", "precio", "total");
                System.out.println("------------------------------------------------------------------------");
                while (resultado.next()) {

                    String producto = resultado.getString("nombre");
                    int stock = resultado.getInt("stock");
                    double precio = resultado.getDouble("precio_por_unidad");
                    double total = stock*precio;
                    acumulacion =acumulacion+ total;

                    System.out.printf("%-25s %-15s %-20s %-20s\n", producto, stock, precio,total);
                }
                System.out.println("------------------------------------------------------------------------");


                System.out.println("total: $"+acumulacion);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //ejecutar lista en main
    public ArrayList<Vendedor> listadoDeVendedores() {

        ArrayList<Vendedor>  arrayList= new ArrayList<Vendedor>();

        String consulta = "SELECT * FROM vendedores";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);


        if (resultado != null) {
            try {

                while (resultado.next()) {

                    int id = resultado.getInt("vendedor_id");
                    String nombre = resultado.getString("nombre");
                    String apellido = resultado.getString("apellido");
                    int dni = resultado.getInt("dni");
                    String fechaNacimiento = resultado.getString("fecha_nacimiento");
                    String fechaContratacion = resultado.getString("fecha_contratacion");

                    Vendedor vendedor = new Vendedor(id,nombre,apellido,dni,fechaNacimiento,fechaContratacion);

                    arrayList.add(vendedor);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return arrayList;

    }



}

//clase DBHELPER
class DBHelper {

    //datos de la BD
    private static final String URL = "jdbc:mysql://localhost:8889/ExamenJava2";
    private static final String USER = "test";
    private static final String PASSWORD = "test";


    // Método para ejecutar una consulta sin devolver resultados
    public static void ejecutarConsulta(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear la declaración
            try (PreparedStatement statement = connection.prepareStatement(consulta)) {
                // Ejecutar la consulta
                statement.executeUpdate();
            }

            // Cerrar la conexión
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para ejecutar una consulta y devolver un conjunto de resultados
    public static ResultSet ejecutarConsultaConResultado(String consulta) {
        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Crear la declaración
            PreparedStatement statement = connection.prepareStatement(consulta);

            // Ejecutar la consulta y devolver el conjunto de resultados
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}

//objetos
class Producto {

    private int id;
    private String nombre;
    private double precioPorUnidad;
    private int stock;

    public Producto(int id, String nombre, double precioPorUnidad, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precioPorUnidad = precioPorUnidad;
        this.stock = stock;
    }

    //ver si funciona y si hace lo que pide la consigna NO HACE LO QUE PIDE DEL TODO
    public static Producto obtenerProducto(int productoID){

        String consulta = "SELECT * FROM productos WHERE producto_id = '"+productoID+"'";
        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);

        if (resultado != null) {
            try {

                if(resultado.next()){

                    int id = resultado.getInt("producto_id");
                    String nombre = resultado.getString("nombre");
                    Double precioUnidad = resultado.getDouble("precio_por_unidad");
                    int stock = resultado.getInt("stock");

                    Producto productoEncontrado =new Producto(id, nombre, precioUnidad, stock);
                    return  productoEncontrado;

                }else {
                    System.out.println("no existe ese producto");
                    return null;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public static Producto obtenerProductoMasVendido(){


        String consulta = "SELECT producto_id, SUM(cantidad_vendida) as total_vendido\n" +
                "FROM ventas\n" +
                "GROUP BY producto_id\n" +
                "ORDER BY total_vendido DESC\n" +
                "LIMIT 1";

        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consulta);

        if (resultado != null) {

            try {

                if(resultado.next()){

                    int id = resultado.getInt("producto_id");

                    return  obtenerProducto(id);

                }else {
                    System.out.println("no existe ese producto");
                    return null;
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public String toString() {
        return "\nProducto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precioPorUnidad=" + precioPorUnidad +
                ", stock=" + stock +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(double precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
class Vendedor {

    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private String fechaNacimiento;
    private String fechaContratacion;


    public Vendedor(int id, String nombre, String apellido, int dni, String fechaNacimiento, String fechaContratacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
    }
    public Vendedor( String nombre, String apellido, int dni, String fechaNacimiento, String fechaContratacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
    }

    //probar este contructor
    public Vendedor(String consultaBusqueda) {
        // Implementa el código para cargar los datos del vendedor usando la consulta proporcionada

        ResultSet resultado = DBHelper.ejecutarConsultaConResultado(consultaBusqueda);

        try {
            if(resultado.next()){
                this.id = resultado.getInt("vendedor_id");
                this.nombre = resultado.getString("nombre");
                this.apellido = resultado.getString("apellido");
                this.dni = resultado.getInt("dni");
                this.fechaNacimiento = resultado.getString("fecha_nacimiento");
                this.fechaContratacion = resultado.getString("fecha_contratacion");

            }else {
                System.out.println("no existe ese vendedor");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void mostrarDatos(ResultSet resultado){
        if (resultado != null) {
            try {
                System.out.println("Datos del vendedor:");
                System.out.printf("%-10s %-15s %-15s %-20s %-15s %-15s\n", "ID", "Nombre", "Apellido", "dni", "Fecha nacimiento", "fecha contratacion");

                if(resultado.next()){

                    int id = resultado.getInt("id");
                     String nombre = resultado.getString("nombre");
                    String apellido = resultado.getString("apellido");
                    int dni = resultado.getInt("dni");
                    Date fechaNacimiento = resultado.getDate("fecha_nacimiento");
                    Date fechaContratacion = resultado.getDate("fecha_contratacion");

                    System.out.printf("%-10s %-15s %-15s %-20s %-15s %-15s\n", id ,nombre, apellido, dni, fechaNacimiento, fechaContratacion);

                }else {
                    System.out.println("no existe ese vendedor");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "\nVendedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni=" + dni +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", fechaContratacion='" + fechaContratacion + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
