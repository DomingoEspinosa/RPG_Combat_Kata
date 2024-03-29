package com.codurance.rpg;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codurance.rpg.CharacterRpg.MAXIMUM_HEALTH;
import static com.codurance.rpg.CharacterRpg.MINIMUM_HEALTH;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CharacterRpgShould {


    private CharacterRpg characterRpg;


    @BeforeEach
    void setUp() {
        characterRpg = new CharacterRpg();
    }

    @Test
    void be_created_with_maximum_health() {
        assertThat(characterRpg.getHealth(), is(MAXIMUM_HEALTH));
    }

    @Test
    void be_created_with_level_1() {
        assertThat(characterRpg.getLevel(), is(1));
    }

    @Test
    void be_created_alive() {
        assertTrue(characterRpg.isAlive());
    }

    @Test
    void deal_damage_to_other_character() {
        CharacterRpg attacker = new CharacterRpg();
        attacker.dealDamage(10, characterRpg);
        assertThat(characterRpg.getHealth(), is(990));
    }

    @Test
    void kill_other_character() {
        CharacterRpg attacker = new CharacterRpg();

        attacker.dealDamage(500, characterRpg);
        attacker.dealDamage(501, characterRpg);

        assertThat(characterRpg.getHealth(), is(MINIMUM_HEALTH));
        assertFalse(characterRpg.isAlive());
    }

    @Test
    void heal_to_other_characters() {
        CharacterRpg attacker = new CharacterRpg();
        CharacterRpg friendCharacter = new CharacterRpg();

        attacker.dealDamage(20, characterRpg);
        friendCharacter.heal(10, characterRpg);

        assertThat(characterRpg.getHealth(), is(990));

    }

    @Test
    void not_heal_a_dead_character() {
        CharacterRpg attacker = new CharacterRpg();
        CharacterRpg friendCharacter = new CharacterRpg();

        attacker.dealDamage(1001, characterRpg);
        friendCharacter.heal(20, characterRpg);

        assertThat(characterRpg.getHealth(), is(MINIMUM_HEALTH));
    }

    @Test
    void not_heal_over_maximum_health() {

        CharacterRpg friendCharacter = new CharacterRpg();
        CharacterRpg attacker = new CharacterRpg();

        attacker.dealDamage(20, characterRpg);
        friendCharacter.heal(1001, characterRpg);

        assertThat(characterRpg.getHealth(), is(MAXIMUM_HEALTH));
    }
}
