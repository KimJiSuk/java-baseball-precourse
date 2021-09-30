package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Game {
    private final List<Integer> baseballNumbers;

    public Game() {
        Set<Integer> setNumbers = new HashSet<>();

        while (setNumbers.size() < Constants.NUMBER_OF_NUMBERS) {
            setNumbers.add(Randoms.pickNumberInRange(Constants.LOW_NUMBER, Constants.HIGH_NUMBER));
        }

        baseballNumbers = new ArrayList<>(setNumbers);
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }

    public BallCountDTO confirmBaseballNumbers(List<Integer> inputNumbers) {
        int strike = getStrike(inputNumbers);
        int ball = getBall(inputNumbers, strike);

        return new BallCountDTO(strike, ball);
    }

    private int getStrike(List<Integer> inputNumbers) {
        int count = 0;

        for (int i = 0; i < inputNumbers.size(); i++) {
            count += (Objects.equals(inputNumbers.get(i), baseballNumbers.get(i))) ? 1 : 0;
        }

        return count;
    }

    private int getBall(List<Integer> inputNumbers, int strikeCount) {
        int count = 0;

        for (Integer inputNumber : inputNumbers) {
            count += (baseballNumbers.contains(inputNumber)) ? 1 : 0;
        }

        return count - strikeCount;
    }

}
