package sistemaGestionEmpleados;

//Este tipo de empleado gana un sueldo por horas trabajadas.
public class EmpleadoPorHora extends Empleado implements Impuesto{

    //atributos
    int horasTrabajadas;
    double sueldoTotal;

    //constructor
    public EmpleadoPorHora(String nombre, int id, int horasTrabajadas, double sueldoBase){
        this.nombre=nombre;
        this.id=id;
        this.horasTrabajadas=horasTrabajadas;
        this.sueldoBase=sueldoBase;
    }

    @Override
    public double calcularSueldo(){
        this.sueldoTotal=horasTrabajadas*sueldoBase;
        return sueldoTotal;
    }

    //implementa la el metodo de la interfaz aplicando 21% de impuestos
    @Override
    public double calcularImpuesto(){
        return sueldoTotal*0.21;
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
        return "\nid: "+id+"\nnombre: "+ nombre+"\nhoras trabajadas: "+horasTrabajadas+"\nsueldo total: $"+calcularSueldo()+"\nimpuestos: $"+calcularImpuesto();
    }


    
}
