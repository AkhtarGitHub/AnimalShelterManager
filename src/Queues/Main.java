package Queues;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        // Adding 5 dogs and 5 cats to the shelter
        shelter.enqueue(new Dog("Buddy", 0));
        shelter.enqueue(new Cat("Whiskers", 0));
        shelter.enqueue(new Dog("Max", 0));
        shelter.enqueue(new Cat("Luna", 0));
        shelter.enqueue(new Dog("Charlie", 0));
        shelter.enqueue(new Cat("Mittens", 0));
        shelter.enqueue(new Dog("Rocky", 0));
        shelter.enqueue(new Cat("Cleo", 0));
        shelter.enqueue(new Dog("Cooper", 0));
        shelter.enqueue(new Cat("Simba", 0));


        // Adoption process
        Animal adoptedAnimal;
        while ((adoptedAnimal = shelter.dequeueAny()) != null) {
            System.out.println(adoptedAnimal.getName() + " was adopted.");
        }
    }
}
