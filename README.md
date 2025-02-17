Animal Shelter Manager - Documentation
Version: 1.0
Last Updated: February 2025

Table of Contents
Project Overview
Features
System Requirements
Project Structure
Class Descriptions
Implementation Details
Usage Guide
Code Example
Performance Considerations
Future Enhancements
Conclusion

1️ Project Overview
Animal Shelter Manager is a Java-based application that efficiently manages an animal shelter’s intake and adoption process. The shelter operates under a First In, First Out (FIFO) adoption policy, allowing users to adopt:
The oldest animal in the shelter, regardless of type.
The oldest dog if they prefer a dog.
The oldest cat if they prefer a cat.
Users cannot select a specific animal, only the type of animal they want.
This project leverages Java’s Queue data structure to maintain order and facilitate fast enqueue (intake) and dequeue (adoption) operations.

2️ Features
✔ Efficient FIFO Queue Management – Ensures animals are adopted in the correct order.
✔ Separate Dog & Cat Queues – Maintains fairness in the adoption process.
✔ Support for Multiple Adoption Requests – Users can choose to adopt any animal or a specific type.
✔ Extensible & Modular Code – Can be expanded to include more animal types.
✔ Error Handling – Manages cases where no animals are available for adoption.

3️ System Requirements
Java Version: JDK 11 or later (tested on JDK 21).
Development Environment: IntelliJ IDEA (recommended) or Eclipse.
Operating System: Windows, macOS, or Linux.
Build Tool (Optional): Maven or Gradle for dependency management.

4️ Project Structure
css
CopyEdit
📂 AnimalShelterManager
 ┣ 📂 src
 ┃ ┣ 📂 Queues
 ┃ ┃ ┣ 📜 Animal.java
 ┃ ┃ ┣ 📜 Dog.java
 ┃ ┃ ┣ 📜 Cat.java
 ┃ ┃ ┣ 📜 AnimalShelter.java
 ┃ ┃ ┣ 📜 Main.java
 ┗ 📜 README.md  (Documentation)

Description:
Animal.java – Base class for all animals.
Dog.java – Represents a dog in the shelter.
Cat.java – Represents a cat in the shelter.
AnimalShelter.java – Implements FIFO adoption system using queues.
Main.java – Driver class that initializes and runs the application.
README.md – Project documentation.

5 Class Descriptions
Animal.java
Represents a generic animal with a name and arrival order.
package Queues;

public class Animal {
    private final String name;
    private final int order;

    public Animal(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public String getName() {
        return name;
    }
}


Dog.java (Extends Animal)
package Queues;

public class Dog extends Animal {
    public Dog(String name, int order) {
        super(name, order);
    }
}



Cat.java (Extends Animal)
package Queues;

public class Cat extends Animal {
    public Cat(String name, int order) {
        super(name, order);
    }
}



AnimalShelter.java (Manages Enqueue & Dequeue Operations)

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


Main.java 
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



6️ Implementation Details
enqueue(Animal animal) – Adds an animal to the appropriate queue.
dequeueAny() – Adopts the oldest animal from either queue.
dequeueDog() – Adopts the oldest dog.
dequeueCat() – Adopts the oldest cat.

7️ Usage Guide
How to Run the Program
Clone or Download the Project
git clone https://github.com/https://github.com/AkhtarGitHub/AnimalShelterManager.git/AnimalShelterManager.git
cd AnimalShelterManager
Open in IntelliJ IDEA
Select src/Queues/Main.java and click Run.

8️ Code Example

Animal Shelter is successfully created.
Dog Buddy is added to the shelter.
Cat Whiskers is added to the shelter.
Dog Max is added to the shelter.
Cat Luna is added to the shelter.
Dog Charlie is added to the shelter.
Cat Mittens is added to the shelter.
Dog Rocky is added to the shelter.
Cat Cleo is added to the shelter.
Dog Cooper is added to the shelter.
Cat Simba is added to the shelter.

Buddy was adopted.
Whiskers was adopted.
Max was adopted.
Luna was adopted.
Charlie was adopted.
Mittens was adopted.
Rocky was adopted.
Cleo was adopted.
Cooper was adopted.
Simba was adopted.


10 Future Enhancements
Support for More Animal Types (e.g., Rabbits, Birds).
Graphical User Interface (GUI) Implementation.
Database Integration for Persistent Storage.

11️ Conclusion
The Animal Shelter Manager efficiently handles intake and adoption processes using Java's Queue data structure. The project demonstrates modular, scalable, and efficient code, making it an excellent foundation for future enhancements.

Developed By: Akhtar Hossain | Date: February 2025
For more details, contact: [mohammad.hossain@keyin.com]
