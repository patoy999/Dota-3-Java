package com.mycompany.dota3;

import java.util.Random;

public class Warrior extends Game {
    public Warrior(String name, int health) {
        super(name, health);
        
    }
    private int skillUsageCount;
    private int specialUsageCount;
    @Override
    public void attack(Game opponent, String attackType) {
        int damage;

        switch (attackType.toLowerCase()) {
            case "basic":
                damage = new Random().nextInt(11); // Random damage between 0 and 10
                break;
            case "skill":
                if (skillUsageCount < 3) {
                    damage = new Random().nextInt(21); // Random damage between 0 and 20
                    skillUsageCount++;
                } else {
                    System.out.println("Skill attack cannot be used more than 3 times.");
                    return;
                }
                break;
            case "special":
                if (specialUsageCount < 1) {
                    damage = 50; // Fixed damage for special attack
                    specialUsageCount++;
                } else {
                    System.out.println("Special attack cannot be used more than once.");
                    return;
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid attack type");
        }

        System.out.println(getName() + " is using " + attackType + " attack on " + opponent.getName());
        opponent.takeDamage(damage);
    }

    @Override
    public void takeDamage(int damage) {
        setHealth(getHealth() - damage);
        System.out.println(getName() + " took " + damage + " damage.");
        if (getHealth() <= 0) {
            System.out.println(getName() + " has been defeated!");
        } else {
            System.out.println(getName() + "'s remaining health: " + getHealth());
        }
    }

    @Override
    public void display() {
        System.out.println(getName() + " - Health: " + getHealth());
    }
}
