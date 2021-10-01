package baseball;

import nextstep.utils.Console;

public class GameView {
    public void printEnterNumber() {
        System.out.print(Constants.ENTER_NUMBER_MESSAGE);
    }

    public String readLine() {
        return Console.readLine();
    }

    public void printBallCount(BallCountDTO ballCountDTO) {
        if (ballCountDTO.isNothing()) {
            printNothing();
            return;
        }

        printStrike(ballCountDTO.getStrike());
        printBall(ballCountDTO.getBall());
        System.out.println();
    }

    public void printRestartInputError() {
        System.out.println(Constants.RESTART_ERROR_MESSAGE);
    }

    public void printInputError() {
        System.out.println(Constants.INPUT_ERROR_MESSAGE);
    }

    public void printGameOverMessage() {
        System.out.println(Constants.GAME_OVER_MESSAGE);
    }

    public void printNewGameMessage() {
        System.out.println(Constants.NEW_GAME_MESSAGE);
    }

    private void printNothing() {
        System.out.println(Constants.NOTHING_MESSAGE);
    }

    private void printStrike(int strike) {
        if (strike != 0) {
            System.out.print(strike + Constants.STRIKE_MESSAGE + " ");
        }
    }

    private void printBall(int ball) {
        if (ball != 0) {
            System.out.print(ball + Constants.BALL_MESSAGE);
        }
    }

}
