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

    private void attack(RpgCharacter enemy) {
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

    private void thornDamage(RpgCharacter enemy) {
        if (enemy.currentWeapon.equals(Weapon.SWORD)) {
            switch (currentWeapon) {
                case HAND -> {
                    this.takeDamage(enemy.defensePoints / 2);
                }
                case BOW -> {
                    this.takeDamage(0);
                }
                case SWORD -> {
                    this.takeDamage(enemy.defensePoints / 20);
                }
                case AXE -> {
                    this.takeDamage(enemy.defensePoints / 10);
                }
            }
        } else {
            switch (currentWeapon) {
                case HAND -> {
                    this.takeDamage(enemy.defensePoints);
                }
                case BOW -> {
                    this.takeDamage(0);
                }
                case SWORD -> {
                    this.takeDamage(enemy.defensePoints / 10);
                }
                case AXE -> {
                    this.takeDamage(enemy.defensePoints / 5);
                }
            }
        }
    }

    protected void takeDamage (Integer damage) {
        health -= damage;
    }
}