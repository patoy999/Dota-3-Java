package com.mycompany.dota3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TurnGame extends Dota3{
    private Game player;
    private Game enemy;
    private String difficulty;

   Scanner sc = new Scanner(System.in); 
    //constructor
   public TurnGame(Game player, String difficulty) {
        this.player = player;
        this.difficulty = difficulty;
        initializeEnemy();
    }

    private void initializeEnemy() {
        List<Game> enemies = new ArrayList<>();

        // Create enemies with different health and damage based on difficulty
        switch (difficulty.toLowerCase()) {
            case "easy":
                enemies.add(new Warrior("Faceless Void", 100));
                enemies.add(new Warrior("Medusa", 100));
                enemies.add(new Warrior("Shadow fiend", 100));
                break;
            case "medium":
                enemies.add(new Warrior("Faceless Void", 200));
                enemies.add(new Warrior("Medusa", 200));
                enemies.add(new Warrior("Shadow fiend", 200));
                break;
            case "hard":
                enemies.add(new Warrior("Faceless Void", 300));
                enemies.add(new Warrior("Medusa", 300));
                enemies.add(new Warrior("Shadow fiend", 300));
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty level.");
        }

        Collections.shuffle(enemies);
        enemy = enemies.get(0);
    }


    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nWELCOME TO DOTA 3 THE BATTLE IS ABOUT TO BEGIN!");

        while (player != null && enemy != null && player.getHealth() > 0 && enemy.getHealth() > 0) {
            System.out.println("Player's turn - " + player.getName());
            performPlayerTurn();

            if (enemy.getHealth() > 0) {
                System.out.println("\nEnemy's turn - " + enemy.getName());
                performEnemyTurn();
            }
        }

        // Display the final state of the battle
        if (player != null) {
            System.out.println("\nFinal state of player:");
            player.display();
        }

        if (enemy != null) {
            System.out.println("\nFinal state of enemy:");
            enemy.display();
        }

        scanner.close();
    }

    private void performPlayerTurn() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your attack type: (1) Basic, (2) Skill, (3) Special");
        int choice = scanner.nextInt();

        String attackType;
        switch (choice) {
            case 1:
                attackType = "basic";
                break;
            case 2:
                attackType = "skill"; 
                break;
            case 3:
                attackType = "special";
                break;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }

        player.attack(enemy, attackType);
    }

    private void performEnemyTurn() {
        // For simplicity, the enemy always performs a basic attack
        enemy.attack(player, "basic");
    }
}
