package org.example.character;

public class Warrior extends RpgCharacter {
    private Integer rage;

    public Warrior(String name) {
        this.rage = 0;
        this.name = name;
        this.attackPoints = 120;
        this.defensePoints = 30;
        this.health = 100;
    }
}