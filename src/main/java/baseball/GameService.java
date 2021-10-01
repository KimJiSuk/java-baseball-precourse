package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.Set;

public class GameService {
    GameView gameView = new GameView();
    Game game;
    BallCountDTO ballCountDTO;

    public void generateGame() {
        game = new Game();
        ballCountDTO = new BallCountDTO(0, 0, false, true);
    }

    public void startGame() {
        while (!ballCountDTO.isStrikeout()) {
            List<Integer> inputNumbers = readInputNumber();
            ballCountDTO = game.confirmBaseballNumbers(inputNumbers);
            gameView.printBallCount(ballCountDTO);
        }

        gameView.printGameOverMessage();
    }

    public boolean isRestartGame() {
        gameView.printNewGameMessage();
        String input = gameView.readLine();

        if (Arrays.asList(Constants.START_COMMAND, Constants.STOP_COMMAND).contains(input)) {
            return input.equals(Constants.START_COMMAND);
        }

        gameView.printRestartInputError();
        return isRestartGame();
    }

    private List<Integer> readInputNumber() {
        gameView.printEnterNumber();
        String input = gameView.readLine();

        if (checkInputNumber(input)) {
            return convertInputToList(input);
        }

        gameView.printInputError();
        return readInputNumber();
    }

    private boolean checkInputNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            set.add(Character.getNumericValue(input.charAt(i)));
        }

        return input.length() == Constants.NUMBER_OF_NUMBERS && set.size() == input.length();
    }

    private List<Integer> convertInputToList(String input) {
        List<Integer> inputNumbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            inputNumbers.add(Character.getNumericValue(input.charAt(i)));
        }

        return inputNumbers;
    }
}
