package com.mycompany.dota3;

public abstract class Game {
    private String name;
    private int health;

    public Game(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public abstract void attack(Game opponent, String attackType);

    public abstract void takeDamage(int damage);

    public abstract void display();

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for health
    public int getHealth() {
        return health;
    }

    // Setter for health
    public void setHealth(int health) {
        this.health = health;
    }
}
