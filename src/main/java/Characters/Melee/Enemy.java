package Characters.Melee;

import Weapons.Weapon;

import java.util.ArrayList;

public class Enemy extends Melee {

    public Enemy(String name, int maxHealth, int power, ArrayList<Weapon> weapons, int purse) {
        super(name, maxHealth, power, weapons);
        this.purse = purse;

    }
}
