package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class GameTest {
    @Test
    public void generateBaseballNumber() {
        for (int i = 0; i < 10000; i++) {
            Game game = new Game();

            assertThat(game.getBaseballNumbers())
                    .isNotNull()
                    .hasSize(Constants.NUMBER_OF_NUMBERS);

            for (Integer number : game.getBaseballNumbers()) {
                assertThat(number)
                        .isGreaterThanOrEqualTo(Constants.LOW_NUMBER)
                        .isLessThanOrEqualTo(Constants.HIGH_NUMBER);
                assertThat(game.getBaseballNumbers())
                        .containsOnlyOnce(number);
            }
        }
    }

    @Test
    public void confirmBaseballNumber() {
        Game game = new Game();

        /* 3스트라이크 */
        List<Integer> temp = new ArrayList<>(game.getBaseballNumbers());
        assertThat(game.confirmBaseballNumbers(temp)).usingRecursiveComparison()
                .isEqualTo(new BallCountDTO(Constants.NUMBER_OF_NUMBERS, 0, true, false));

        /* 1스트라이크 2볼, swap */
        Collections.swap(temp, 0, 1);
        assertThat(game.confirmBaseballNumbers(temp)).usingRecursiveComparison()
                .isEqualTo(new BallCountDTO(1, Constants.NUMBER_OF_NUMBERS - 1, false, false));

        /* 3볼 */
        temp = new ArrayList<>(game.getBaseballNumbers());
        temp.set(0, game.getBaseballNumbers().get(Constants.NUMBER_OF_NUMBERS - 1));

        for (int i = 1; i < Constants.NUMBER_OF_NUMBERS; i++) {
            temp.set(i, game.getBaseballNumbers().get(i - 1));
        }

        assertThat(game.confirmBaseballNumbers(temp)).usingRecursiveComparison()
                .isEqualTo(new BallCountDTO(0, Constants.NUMBER_OF_NUMBERS, false, false));

        /* 2스트라이크 */
        temp = new ArrayList<>(game.getBaseballNumbers());
        temp.set(0, 0);
        assertThat(game.confirmBaseballNumbers(temp)).usingRecursiveComparison()
                .isEqualTo(new BallCountDTO(Constants.NUMBER_OF_NUMBERS - 1, 0, false, false));

        /* 1스트라이크 */
        temp.set(1, 0);
        assertThat(game.confirmBaseballNumbers(temp)).usingRecursiveComparison()
                .isEqualTo(new BallCountDTO(Constants.NUMBER_OF_NUMBERS - 2, 0, false, false));

        /* 낫싱 */
        for (int i = 2; i < Constants.NUMBER_OF_NUMBERS; i++) {
            temp.set(i, 0);
        }
        assertThat(game.confirmBaseballNumbers(temp)).usingRecursiveComparison()
                .isEqualTo(new BallCountDTO(0, 0, false, true));

    }

}
