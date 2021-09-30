package baseball;

public class BallCountDTO {
    int strike;
    int ball;
    boolean strikeout = false;
    boolean nothing = false;

    public BallCountDTO(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;

        if (strike == 0 && ball == 0) {
            nothing = true;
        }

        if (strike == Constants.NUMBER_OF_NUMBERS) {
            strikeout = true;
        }
    }
}
