package com.codurance.rpg.player;

public class CharacterRpg {

    private int health = 1000;
    private int level = 1;

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void dealDamage(int damage, CharacterRpg defender) {
        defender.receiveAttack(damage);
    }

    private void receiveAttack(int damage) {
        health -= damage;
        if (!isAlive()) {
            health = 0;
        }
    }

    public void heal(int pointOfLive, CharacterRpg friendCharacter) {
        friendCharacter.applyPointsOfLive(pointOfLive);
    }

    private void applyPointsOfLive(int pointOfLive) {
        if (isAlive()){
            health += pointOfLive;
        }
    }
}
