package sistemaGestionEmpleados;

//Este tipo de empleado gana un sueldo base más una comisión por ventas. 
public class EmpleadoComision extends Empleado implements Impuesto{

    //atributos
    double ventasRealizadas;
    double sueldoTotal;

    //constructor
    public EmpleadoComision(String nombre, int id, double ventasRealizadas, double sueldoBase){
        this.nombre=nombre;
        this.id=id;
        this.ventasRealizadas=ventasRealizadas;
        this.sueldoBase=sueldoBase;
    }

    //en esta clase, el "sueldo base" es el precio de cada venta
    @Override
    public double calcularSueldo(){
        this.sueldoTotal=ventasRealizadas+sueldoBase;
        return sueldoTotal;
    }

    //implementa la el metodo de la interfaz aplicando 20% de impuestos
    @Override
    public double calcularImpuesto(){
        return sueldoTotal*0.20;
    }

    //getters
    public int getid(){
        return id;
    }
    public String getnombre(){
        return nombre;
    }
    public double getsueldoBase(){
        return sueldoBase;
    }

    //setters
    public void setid( int id){
        this.id=id;
    }
    public void setnombre(String nombre){
        this.nombre=nombre;
    }
    public void setsueldoBase(double nuevoSueldo){
        this.sueldoBase=nuevoSueldo;
    }

    @Override
    public String toString(){
        return "\nid: "+id+"\nnombre: "+ nombre+"\nventas realizadas: "+ventasRealizadas+"\nsueldo total: $"+calcularSueldo()+"\nimpuestos: $"+calcularImpuesto();
    }

    
    
}
