package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;


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
        int strike = getStrikes(inputNumbers);
        int ball = getBalls(inputNumbers, strike);
        boolean strikeout = (strike == Constants.NUMBER_OF_NUMBERS);
        boolean nothing = (strike == 0 && ball == 0);

        return new BallCountDTO(strike, ball, strikeout, nothing);
    }

    private int getStrikes(List<Integer> inputNumbers) {
        int count = 0;

        for (int i = 0; i < inputNumbers.size(); i++) {
            count += getStrike(baseballNumbers.get(i), inputNumbers.get(i));
        }

        return count;
    }

    private int getStrike(int gameNumber, int inputNumber) {
        if (gameNumber == inputNumber) {
            return 1;
        }

        return 0;
    }

    private int getBalls(List<Integer> inputNumbers, int strikeCount) {
        int count = 0;

        for (Integer inputNumber : inputNumbers) {
            count += getBall(inputNumber);
        }

        return count - strikeCount;
    }

    private int getBall(int inputNumber) {
        if (baseballNumbers.contains(inputNumber)) {
            return 1;
        }

        return 0;
    }

}
