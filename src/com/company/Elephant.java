package com.company;

public class Elephant {
    private int origin;
    private int destination;
    private int weight;
    private boolean isReplaced;

    public Elephant(int origin, int destination, int weight) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.isReplaced = false;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setReplaced(boolean replaced) {
        isReplaced = replaced;
    }

    public int getOrigin() {
        return origin;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isReplaced() {
        return isReplaced;
    }
}
