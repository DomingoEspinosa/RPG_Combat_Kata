package com.codurance.rpg;

public class CharacterRpg {

    static final int MAXIMUM_HEALTH = 1000;
    static final int MINIMUM_HEALTH = 0;
    private int health = MAXIMUM_HEALTH;
    private int level = 1;

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return health > MINIMUM_HEALTH;
    }

    public void dealDamage(int damage, CharacterRpg defender) {
        defender.receiveAttack(damage);
    }

    private void receiveAttack(int damage) {
        health -= damage;
        if (!isAlive()) {
            health = MINIMUM_HEALTH;
        }
    }

    public void heal(int pointOfLive, CharacterRpg friendCharacter) {
        friendCharacter.applyPointsOfLive(pointOfLive);
    }

    private void applyPointsOfLive(int pointOfLive) {
        if (isAlive()) {
            health += pointOfLive;
            if (health > MAXIMUM_HEALTH) {
                health = MAXIMUM_HEALTH;
            }
        }
    }
}
