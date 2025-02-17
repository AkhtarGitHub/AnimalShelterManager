package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {
    private final Queue<Dog> dogs;
    private final Queue<Cat> cats;
    private int order;

    public AnimalShelter() {
        dogs = new LinkedList<>();
        cats = new LinkedList<>();
        order = 0;
        System.out.println("Animal Shelter is successfully created.");
    }

    // Enqueue method with correct order assignment
    public void enqueue(Animal animal) {
        if (animal instanceof Dog) {
            dogs.add(new Dog(animal.getName(), order));
            System.out.println("Dog " + animal.getName() + " is added to the shelter.");
        } else if (animal instanceof Cat) {
            cats.add(new Cat(animal.getName(), order));
            System.out.println("Cat " + animal.getName() + " is added to the shelter.");
        }
        order++;
    }

    // Dequeue the oldest animal (either dog or cat)
    public Animal dequeueAny() {
        if (dogs.isEmpty() && cats.isEmpty()) {
            System.out.println("No animals available for adoption.");
            return null;
        } else if (dogs.isEmpty()) {
            return dequeueCat();
        } else if (cats.isEmpty()) {
            return dequeueDog();
        } else {
            // Prevent NullPointerException
            Dog oldestDog = dogs.peek();
            Cat oldestCat = cats.peek();

            if (oldestDog == null) {
                return dequeueCat();
            } else if (oldestCat == null) {
                return dequeueDog();
            } else if (oldestDog.getOrder() < oldestCat.getOrder()) {
                return dequeueDog();
            } else {
                return dequeueCat();
            }
        }
    }

    // Dequeue the oldest dog
    public Dog dequeueDog() {
        if (!dogs.isEmpty()) {
            Dog dog = dogs.poll();
            System.out.println("Dog " + dog.getName() + " has been adopted.");
            return dog;
        } else {
            System.out.println("No dogs available for adoption.");
            return null;
        }
    }

    // Dequeue the oldest cat
    public Cat dequeueCat() {
        if (!cats.isEmpty()) {
            Cat cat = cats.poll();
            System.out.println("Cat " + cat.getName() + " has been adopted.");
            return cat;
        } else {
            System.out.println("No cats available for adoption.");
            return null;
        }
    }
}
