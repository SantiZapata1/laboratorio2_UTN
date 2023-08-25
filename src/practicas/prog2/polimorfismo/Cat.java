public class Cat extends Animal {
    //aplicamos polimorfismo
    public String makeNoise(){
        return super.makeNoise() + " miau";
    }
}
