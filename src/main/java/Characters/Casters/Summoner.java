package Characters.Casters;

import Characters.Adventurer;
import Characters.Behaviours.ICast;
import Minions.Minion;

import java.util.ArrayList;

public class Summoner extends Adventurer{

    private ArrayList<ICast> spells;
    private Minion pet;


    public Summoner(String name, int maxHealth, int power, ArrayList<ICast> spells) {
        super(name, maxHealth, power);
        this.spells = spells;
        this.pet = null;
    }

    public ICast equipSpell(ICast spell) {
        int index = spells.indexOf(spell);
        return spells.get(index);
    }
    public void attack(Adventurer target, ICast spell) {
        ICast equippedSpell = equipSpell(spell);
        int damage = equippedSpell.getSpellModifier() + this.getPower();
        target.takeDamage(damage);
    }

    public void summon() {
        pet = new Minion(100, "Elemental");
    }

    public void takeDamage(int damageAmount){
        if(this.pet == null) {
                this.health -= damageAmount;
            } else {
            this.pet.takeDamage(damageAmount);
            if (!this.pet.isAlive()) {
                this.pet = null;
            }
        }
    }

    public boolean hasPet() {
        return pet != null;
    }

}
