package org.example.character;

public class RpgCharacter {
    protected String name;
    protected Integer health;
    protected Integer defensePoints;
    protected Integer attackPoints;
    private Weapon currentWeapon = Weapon.HAND;

    public void changeWeapon(Weapon weapon) {
        this.currentWeapon = weapon;
    }

    public void attack(RpgCharacter enemy) {
        switch (currentWeapon) {
            case HAND -> {
                enemy.health -= (attackPoints / 100);
            }
            case BOW -> {
                enemy.health -= (attackPoints / 20);
            }
            case SWORD -> {
                enemy.health -= (attackPoints / 10);
            }
            case AXE -> {
                enemy.health -= (attackPoints / 5);
            }
        }
        //enemy.takeDamage(calculateEnemyDamage());
        //this.takeDamage(calculateOwnDamage());
    }

    protected void takeDamage (Integer damage) {
        health -= damage;
    }
}