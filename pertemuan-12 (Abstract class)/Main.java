public class Main {
    public static void main(String[] args) {
        System.out.println("=== Human ===");
        Human human = new Human("Richard");
        human.breathe();
        human.grow();
        human.speak("Iam not an animal, iam an human.");

        System.out.println("\n=== Animal ===");
        Animal animal = new Animal("Cat");
        animal.breathe();
        animal.grow();
        animal.move();

        System.out.println("\n=== Plant ===");
        Plant plant = new Plant("Broccoli");
        plant.breathe();
        plant.grow();
        plant.photosynthesize();
    }
}