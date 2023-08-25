//package practicas.prog2.polimorfismo;

//aplicamos herencia
public class Dog extends Animal{

    //aplicamos polimorfismo
    public String makeNoise(){
        return super.makeNoise() + " guau";
    }

    public String saludar(){
        return "hola";
    }
    
}

