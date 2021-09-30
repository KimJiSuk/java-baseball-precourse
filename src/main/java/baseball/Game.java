package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Game {
    public final int NUMBER_OF_NUMBERS = 3;
    public final int LOW_NUMBER = 1;
    public final int HIGH_NUMBER = 9;

    private final List<Integer> baseballNumbers;

    public Game() {
        Set<Integer> setNumbers = new HashSet<>();

        while (setNumbers.size() < NUMBER_OF_NUMBERS) {
            setNumbers.add(Randoms.pickNumberInRange(LOW_NUMBER, HIGH_NUMBER));
        }

        baseballNumbers = new ArrayList<>(setNumbers);
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }
}
