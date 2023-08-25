//package practicas.prog2.polimorfismo;

public class Main {

    public static void main(String[] args){

        Animal animal1 = new Animal();
        Animal dog1 = new Dog();// upcasting
        Animal cat1 = new Cat();


        Dog myRealDog = (Dog) dog1; // Downcasting


        System.out.println(animal1.makeNoise());
        System.out.println(myRealDog.saludar());
        System.out.println(cat1.makeNoise());


    }
    
}
