package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Game {
    private final List<Integer> baseballNumbers = new ArrayList<>();

    public Game() {
        while (baseballNumbers.size() < Constants.NUMBER_OF_NUMBERS) {
            addNumber(generateNumber());
        }
    }

    private int generateNumber() {
        return Randoms.pickNumberInRange(Constants.LOW_NUMBER, Constants.HIGH_NUMBER);
    }

    private void addNumber(int number) {
        if (!baseballNumbers.contains(number)) {
            baseballNumbers.add(number);
        }
    }

    public List<Integer> getBaseballNumbers() {
        return baseballNumbers;
    }

    public BallCountDTO confirmBaseballNumbers(List<Integer> inputNumbers) {
        int strike = getStrike(inputNumbers);
        int ball = getBall(inputNumbers, strike);
        boolean strikeout = (strike == Constants.NUMBER_OF_NUMBERS);
        boolean nothing = (strike == 0 && ball == 0);

        return new BallCountDTO(strike, ball, strikeout, nothing);
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
