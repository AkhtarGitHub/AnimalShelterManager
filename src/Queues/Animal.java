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
