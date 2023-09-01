package prog2.electrodomesticos;

//superclase electrodomestico
public class Electrodomestico{

    //atributos
    int precioBase;
    String color;
    char consEnergetico;
    int peso;

    //atributos predeterminados constantes
    final int precioBasePred = 100000;
    final int pesoPred=5;
    final char consEnergeticoPred='F';
    final String colorPred="blanco";

    //constructor por defecto
    public Electrodomestico(){
        this.precioBase=precioBasePred;
        this.color=colorPred;
        this.consEnergetico=consEnergeticoPred;
        this.peso=pesoPred;
    }

    //constructor 2
    public Electrodomestico(int precioBase, int peso){
        this.precioBase=precioFinal();
        this.peso=peso;
        this.color="blanco";
        this.consEnergetico='F';
    }

    //constructor 3
    //usamos metodos para las diferentes comprobaciones de los atrib. de cada instancia
    public Electrodomestico(int precioBase, int peso, String color, char consEnergetico){
        this.precioBase=precioFinal();
        this.peso=peso;
        this.color=comprobarColor(color);
        this.consEnergetico=comprobarConsumoEnergetico(consEnergetico);
    }

    //getters
    public int getpeso(){
        return peso;
    }   
    public int getprecioBase(){
        return precioBase;
    }
    public String getcolor(){
        return color;
    }
    public char getconsEnergetico(){
        return consEnergetico;
    }

    /* 
    //setters
    public void setpeso( int peso){
        this.peso=peso;
    }
    public void setprecioBase(int precioBase){
        this.precioBase=precioBase;
    }
    public void setcolor(String color){
        this.color=color;
    }
    public void setconsEnergetico(char consEnergetico){
        this.consEnergetico=consEnergetico;
    }*/

    //metodos
    private char comprobarConsumoEnergetico(char letra){

        if(letra=='A'||letra=='B'||letra=='C'||letra=='D'||letra=='E'||letra=='F'){
            return letra;
        }else{
            return consEnergeticoPred;
        }
    }

    private String comprobarColor(String color){
        if(color.equalsIgnoreCase("blanco")||color.equalsIgnoreCase("negro")||
        color.equalsIgnoreCase("rojo")||color.equalsIgnoreCase("gris")||
        color.equalsIgnoreCase("azul")){

            return color;
        }else{
            return colorPred;
        }
    }
    private int precioFinal(){

        int precioFinal=precioBase;

        switch(this.consEnergetico){
            case 'A' -> precioFinal += 100; 
            case 'B' -> precioFinal += 80; 
            case 'C' -> precioFinal += 60; 
            case 'D' -> precioFinal += 50; 
            case 'E' -> precioFinal += 30; 
            case 'F' -> precioFinal += 10; 

        }

        if(this.peso){

        }else if(){

        }else if(){

        }else if(){

        }


        return precioFinal;

    }



    

}