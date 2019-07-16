import com.codurance.rpg.player.CharacterRpg;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharacterRpgShould {

    private CharacterRpg characterRpg;

    @BeforeEach
    void setUp() {
        characterRpg = new CharacterRpg();
    }

    @Test
    public void be_created_with_health_1000() {
        assertThat(characterRpg.getHealth(), is(1000));
    }

    @Test
    public void be_created_with_level_1() {
        assertThat(characterRpg.getLevel(), is(1));
    }

    @Test
    public void be_created_alive() {
        assertTrue(characterRpg.isAlive());
    }

    @Test
    public void deal_damage_to_other_character() {
        CharacterRpg attacker = new CharacterRpg();
        attacker.dealDamage(10, characterRpg);
        assertThat(characterRpg.getHealth(), is(990));
    }

    @Test
    public void kill_other_character() {
        CharacterRpg attacker = new CharacterRpg();

        attacker.dealDamage(500, characterRpg);
        attacker.dealDamage(501, characterRpg);

        assertThat(characterRpg.getHealth(), is(0));
        assertFalse(characterRpg.isAlive());
    }

    @Test
    public void heal_to_other_characters() {
        CharacterRpg attacker = new CharacterRpg();
        CharacterRpg friendCharacter = new CharacterRpg();

        attacker.dealDamage(20, characterRpg);
        friendCharacter.heal(10, characterRpg);

        assertThat(characterRpg.getHealth(), is(990));

    }
}
