package org.example.character;

public class Mage extends ManaUserCharacter {

    private Boolean hasShield;

    public Mage(String name) {
        this.mana = 0;
        super.name = name;
        this.attackPoints = 90;
        this.defensePoints = 60;
        this.health = 150;
        this.hasShield = false;
    }

    public void castSpell(SpellType spellType) {
        mana--;
        switch (spellType) {
            case ATTACK -> {
            }
            case SHIELD -> {
                hasShield = true;
            }
        }
    }

    @Override
    protected void takeDamage(Integer damage) {
        if (hasShield) {
            hasShield = false;
        } else {
            super.takeDamage(damage);
        }
    }
}
