package Characters.Melee;

import Characters.Adventurer;
import Weapons.Weapon;

import java.util.ArrayList;

public abstract class Melee extends Adventurer {

    private ArrayList<Weapon> weapons;

    public Melee(String name, int maxHealth, int power, ArrayList<Weapon> weapons) {
        super(name, maxHealth, power);
        this.weapons = weapons;
    }

    public Weapon equipWeapon(Weapon weapon) {
        int index = weapons.indexOf(weapon);
        return weapons.get(index);
    }

    public void attack(Adventurer target, Weapon weapon) {
        Weapon equippedWeapon = equipWeapon(weapon);
        int damage = equippedWeapon.getDmgModifier() + this.getPower();
        target.takeDamage(damage);
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void pickUpWeapon(Weapon weapon){
        this.weapons.add(weapon);
    }

}
