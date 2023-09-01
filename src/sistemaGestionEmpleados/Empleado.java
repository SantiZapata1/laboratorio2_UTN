package sistemaGestionEmpleados;

//clase abstracta "Empleado"
public abstract class Empleado {

    String nombre;
    int id;
    double sueldoBase;

    //metodos
    public abstract double calcularSueldo();
    
    public abstract int getid();
    public abstract double getsueldoBase();
    public abstract String getnombre();

    public abstract void setid(int id);
    public abstract void setnombre(String nombre);
    public abstract void setsueldoBase(double nuevoSueldo);

}
