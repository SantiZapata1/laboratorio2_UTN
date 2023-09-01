package sistemaGestionEmpleados;

//Este tipo de empleado gana un sueldo fijo mensual.
public class EmpleadoAsalariado extends Empleado implements Impuesto{

    
    //constructor
    public EmpleadoAsalariado(String nombre, int id, double sueldoBase){
        this.nombre=nombre;
        this.id=id;
        this.sueldoBase=sueldoBase;
    }

    //en esta clase, el "sueldo base" es el sueldo total
    @Override
    public double calcularSueldo(){
        return sueldoBase;
    }
    
    //implementa la el metodo de la interfaz aplicando 22% de impuestos
    @Override
    public double calcularImpuesto(){
        return sueldoBase*0.22;
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
        return "\nid: "+id+"\nnombre: "+ nombre+"\nsueldo total: $"+calcularSueldo()+"\nimpuestos: $"+calcularImpuesto();
    }


}
