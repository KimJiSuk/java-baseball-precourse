package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    @Test
    public void generateBaseballNumber() {
        Game game = new Game();

        assertThat(game.getBaseballNumbers())
                .isNotNull()
                .hasSize(game.NUMBER_OF_NUMBERS);

        for (Integer number : game.getBaseballNumbers()) {
            assertThat(number)
                    .isGreaterThanOrEqualTo(game.LOW_NUMBER)
                    .isLessThanOrEqualTo(game.HIGH_NUMBER);
            assertThat(game.getBaseballNumbers())
                    .containsOnlyOnce(number);
        }
    }

}
