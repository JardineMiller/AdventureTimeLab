import Characters.Adventurer;
import Characters.Behaviours.ICast;
import Rooms.Room;
import Weapons.*;
import Spells.*;
import Characters.Melee.*;
import Characters.Casters.*;

import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class Runner {




    public static void main(String[] args) {
        Spell fireball = new Spell("Fireball", 50);
        Spell lightning = new Spell("Lightning Bolt", 45);
        ArrayList<ICast> summonerSpells = new ArrayList<>();
        summonerSpells.add(fireball);
        summonerSpells.add(lightning);

        Spell bless = new Spell("Bless", 50);
        ArrayList<ICast> clericSpells = new ArrayList<>();
        clericSpells.add(bless);

        Weapon sword = new Weapon("Sword", 25);
        Weapon club = new Weapon("Club", 5);
        Weapon axe = new Weapon("Axe", 30);
        Weapon hammer = new Weapon("Hammer", 35);
        Weapon zweihander = new Weapon("Zweihander", 35);
        ArrayList<Weapon> weapons = new ArrayList<>();
        weapons.add(sword);
        weapons.add(axe);
        weapons.add(hammer);
        weapons.add(zweihander);

        Enemy troll;
        Enemy ogre;

        ogre = new Enemy("Ogre", 600, 30,  weapons, club, 200);
        troll = new Enemy("Troll", 800, 40, weapons, club, 200);

        ArrayList<Enemy> room1Enemies = new ArrayList<>();

        room1Enemies.add(ogre);
        room1Enemies.add(troll);

        ArrayList<Adventurer> players = new ArrayList<>();
        ArrayList<Enemy> enemies = new ArrayList<>();

//         list of strings for classes

        Scanner scanner = new Scanner(System.in);

        for (int x = 0; x < 1; x++) {

            ArrayList<String> chars;
            chars = new ArrayList<>();
            chars.add("1 Cleric \n");
            chars.add("2 Summoner \n");
            chars.add("3 Knight \n");
            chars.add("4 Barbarian \n");
            chars.add("5 Dwarf \n");

            System.out.println("Please choose a class:");
            System.out.println(String.join("", chars));



            String i = scanner.nextLine();
            System.out.println("What is your name?");
            String name = scanner.nextLine();

            switch (i) {
                case "1":
                    Cleric newCleric = new Cleric(name, 500, 200, clericSpells);
                    players.add(newCleric);
                    break;

                case "2":
                    Summoner newSummoner = new Summoner(name, 400, 200, summonerSpells);
                    players.add(newSummoner);
                    break;

                case "3":
                    Knight newKnight = new Knight(name, 400, 200, weapons, 20);
                    players.add(newKnight);
                    break;

                case "4":
                    Barbarian newBarbarian = new Barbarian(name, 400, 200, weapons);
                    players.add(newBarbarian);
                    break;

                case "5":
                    Dwarf newDwarf = new Dwarf(name, 400, 200, weapons);
                    players.add(newDwarf);
                    break;
            }

        }

        Room room1 = new Room("Spooky Library", players, room1Enemies);
        room1.setRoomTreasure();
        ArrayList<String> monsters = new ArrayList<>();
        ArrayList<String> weaponsnames = new ArrayList<>();

        int count = 1;
        for(Enemy enemy : room1.getEnemies()){
            monsters.add(String.format("%s %s \n", count, enemy.getName() ) );
            count++;
        }

        int countweapons = 1;
        for(Weapon weapon: weapons){
            weaponsnames.add(String.format("%s %s \n", countweapons, weapon.getName() ) );
            countweapons++;
        }


        for(Adventurer player : room1.getHeroes()) {
            if (player instanceof Melee) {
                System.out.println(player.getName() + "Who do you want to attack?");
                System.out.println(String.join("", monsters));
                String target = scanner.nextLine();
                int targetnum = parseInt(target) - 1;
                System.out.println(player.getName() + "What weapon do you want to use?");
                System.out.println(String.join("", weaponsnames));
                String weaponchoice = scanner.nextLine();
                int weaponnum = parseInt(weaponchoice) - 1;
                ((Melee) player).attack(room1.getEnemies().get(targetnum), ((Melee) player).getWeapons().get(weaponnum));
            }
        }



    }


}
