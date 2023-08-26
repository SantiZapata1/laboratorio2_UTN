import java.util.ArrayList;
import java.util.Scanner;

public class arrayObjetos {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    
        //declaramos arraylist de tipo animales
        ArrayList<Animal> animales = new ArrayList<>();

        //creamos objetos
        Animal animal1 = new Animal("animal1", 3);
        Animal animal2 = new Animal("animal2", 5);
        Animal perro1 = new Perro("perro1", 8, "golden");
        Animal gato1 = new Gato("gato1", 1, "lagi");

        //comprobaciones
        //System.out.println(perro1.makeNoise());
        //System.out.println(animales.size());

        //cargamos arrayList
        animales.add(animal1);
        animales.add(animal2);
        animales.add(perro1);
        animales.add(gato1);

        //con for-each recorremos todos los objetos del arrayList
        System.out.println("Contenido del ArrayList:");
        for (Animal animalActual : animales) {
            System.out.println("Nombre: " + animalActual.getNombre() + ", Edad: " + animalActual.getEdad()+", makeNoise: "+animalActual.makeNoise());
        }

    }
    
}

class Animal{

    //atributos
    String nombre;
    int edad;

    //constructores
    public Animal(String nombre, int edad){
        this.nombre=nombre;
        this.edad=edad;
    }

    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }

    //metodo
    public String makeNoise(){
        return "hey";
    }

}

class Perro extends Animal{

    String raza;

    public Perro(String nombre, int edad, String raza){
        super(nombre,edad);
        this.raza=raza;
    }

    public String getRaza(){
        return raza;
    }

    @Override
    public String makeNoise(){
        return super.makeNoise()+" guau" ;
    }

} 
class Gato extends Animal{

    String raza;

    public Gato(String nombre, int edad, String raza){
        super(nombre,edad);
        this.raza=raza;
    }

    public String getRaza(){
        return raza;
    }

    @Override
    public String makeNoise(){
        return super.makeNoise()+" miau" ;
    }

} 