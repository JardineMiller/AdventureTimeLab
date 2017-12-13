package Rooms;

import Characters.Adventurer;

import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Adventurer> heroes;
    private ArrayList<Adventurer> enemies;
    private int loot;

    public Room(String name, ArrayList<Adventurer> heroes, ArrayList<Adventurer> enemies) {
        this.name = name;
        this.heroes = heroes;
        this.enemies = enemies;
        this.loot = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Adventurer> getHeroes() {
        return heroes;
    }

    public ArrayList<Adventurer> getEnemies() {
        return enemies;
    }

    public int getLoot() {
        return loot;
    }

    public void setRoomTreasure(){
        int lootTotal = 0;
        for (Adventurer enemy : enemies){
            lootTotal += enemy.getPurse();
        }
        loot = lootTotal;
    }

    public void distributeLoot(){
        int lootShare = loot / heroes.size();
        for (Adventurer hero : heroes){
            hero.increasePurse(lootShare);
        }
    }

    public int enemyCount(){
        return  enemies.size();
    }


    public int heroCount() {
        return heroes.size();
    }
}
