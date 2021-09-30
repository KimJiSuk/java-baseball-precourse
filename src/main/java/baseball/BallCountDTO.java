package baseball;

public class BallCountDTO {
    private final int strike;
    private final int ball;
    private final boolean strikeout;
    private final boolean nothing;

    public BallCountDTO(int strike, int ball, boolean strikeout, boolean nothing) {
        this.strike = strike;
        this.ball = ball;
        this.strikeout = strikeout;
        this.nothing = nothing;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isStrikeout() {
        return strikeout;
    }

    public boolean isNothing() {
        return nothing;
    }

}
