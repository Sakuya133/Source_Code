public class Human extends LivingBeing {
    public Human(String name){
        super(name);
    }

    @Override
    public void grow(){
        System.out.println(name + " growing like a human.");
    }

    public void speak(String sentence){
        System.out.println(name + " says: " + sentence);
    }
}
