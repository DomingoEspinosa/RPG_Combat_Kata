import com.codurance.rpg.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
        assertThat(player.isAlive(), is(true));
    }
}
