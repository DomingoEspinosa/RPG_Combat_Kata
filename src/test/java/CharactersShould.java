import com.codurance.rpg.player.Player;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CharactersShould {
    @Test
    public void be_created_with_health_1000() {
        Player player = new Player();
        assertThat(player.getHealth(), is(1000));
    }
    
}
