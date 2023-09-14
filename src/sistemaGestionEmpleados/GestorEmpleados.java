package sistemaGestionEmpleados;
import java.util.ArrayList;

public class GestorEmpleados {

    ArrayList<Empleado> empleados;

    public GestorEmpleados(){
        empleados = new ArrayList<>();
    }

    //metodo agregar empleado
    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    // Método para eliminar un empleado a traves de su id
    public void eliminarEmpleado(int id) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getid()==id) {
                empleados.get(i).toString();
                empleados.remove(i);
                break;
            }
        }

    }

    // Método para editar los detalles de un empleado
    public void editarEmpleado(int id, String nuevoNombre, double nuevoSueldo) {
        for (Empleado empleado : empleados) {
            if (empleado.getid()==id) {
                empleado.setnombre(nuevoNombre);
                empleado.setsueldoBase(nuevoSueldo);
                System.out.println(empleado);
            }
        }

    }

    public void buscarEmpleado(int id) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getid()==id) {
                System.out.println(empleados.get(i)); 
                break;
            }
        }

    }


    //motodo para retornar todos los objetos empleados
    public void returnGestorEmpleados(){
        for(Empleado empleado:empleados){
            System.out.println("\nid:"+empleado.id+" - nombre:"+empleado.getnombre()+" - sueldo base:"+empleado.sueldoBase);
        }
    }

    
}

