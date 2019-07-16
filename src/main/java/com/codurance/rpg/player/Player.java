package com.codurance.rpg.player;

public class Player {

    private boolean alive = true;
    private int health = 1000;
    private int level = 1;

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public boolean isAlive() {
        return alive;
    }

    public void dealDamage(int damage, Player a) {
        a.health = 990;
    }
}
