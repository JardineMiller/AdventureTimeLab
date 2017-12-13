package Characters.Melee;

import Characters.Adventurer;
import Weapons.Weapon;

import java.util.ArrayList;

public class Enemy extends Melee {

    private Weapon weapon;

    public Enemy(String name, int maxHealth, int power, ArrayList<Weapon> weapons, Weapon weapon, int purse) {
        super(name, maxHealth, power, weapons);
        this.weapon = weapon;
        this.purse = purse;
    }

    public void attack(Adventurer target) {
        int damage = this.weapon.getDmgModifier() + this.getPower();
        target.takeDamage(damage);
    }

}
