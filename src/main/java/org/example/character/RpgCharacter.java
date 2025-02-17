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
        takeDamage(calculateReflectionDamage(enemy));
        enemy.takeDamage(calculateAttackDamage());
    }

    private Integer calculateAttackDamage() {
        switch (currentWeapon) {
            case HAND -> {
                return attackPoints / 100;
            }
            case BOW -> {
                return attackPoints / 20;
            }
            case SWORD -> {
                return attackPoints / 10;
            }
            case AXE -> {
                return attackPoints / 5;
            }
        }
        throw new RuntimeException("attack message");
    }

    private Integer calculateDefenseDamage() {
        switch (currentWeapon) {
            case HAND -> {
                return defensePoints / 100;
            }
            case BOW -> {
                return defensePoints / 20;
            }
            case SWORD -> {
                return defensePoints / 10;
            }
            case AXE -> {
                return defensePoints / 5;
            }
        }
        throw new RuntimeException("defense message");
    }

    private Integer calculateReflectionDamage(RpgCharacter enemy){
        Integer damage = enemy.calculateDefenseDamage();
        switch (currentWeapon) {
            case HAND, AXE -> {
                return damage;
            }
            case BOW -> {
                return 0;
            }
            case SWORD -> {
                return damage / 2;
            }
        }
        throw new RuntimeException("message");
    }

    protected void takeDamage(Integer damage) {
        health -= damage;
    }
}