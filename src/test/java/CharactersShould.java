import com.codurance.rpg.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CharactersShould {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    public void be_created_with_health_1000() {
        assertThat(player.getHealth(), is(1000));
    }

    @Test
    public void be_created_with_level_1() {
        assertThat(player.getLevel(), is(1));
    }

    @Test
    public void be_created_alive() {
        assertTrue(player.isAlive());
    }

    @Test
    public void damage_to_other_player() {
        Player player2 = new Player();
        player2.dealDamage(10,player);
        assertThat(player.getHealth(), is(990));
    }
}
