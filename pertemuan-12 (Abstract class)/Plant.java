public class Plant extends LivingBeing {
    public Plant(String name){
        super(name);
    }

    @Override
    public void grow(){
        System.out.println(name + " growing like a plant.");
    }

    public void photosynthesize(){
        System.out.println(name + " is photosynthesis.");
    }
}