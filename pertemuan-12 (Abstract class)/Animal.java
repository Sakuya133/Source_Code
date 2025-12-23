public class Animal extends LivingBeing {
    public Animal(String name){
        super(name);
    }

    @Override
    public void grow(){
        System.out.println(name + " growing like a animal.");
    }

    public void move(){
        System.out.println(name + " is moving.");
    }
}
