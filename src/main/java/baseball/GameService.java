package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        do {
            gameView.printEnterNumber();
            List<Integer> inputNumbers = readInputNumber();

            if (!checkInputNumber(inputNumbers)) {
                continue;
            }

            ballCountDTO = game.confirmBaseballNumbers(inputNumbers);
            gameView.printBallCount(ballCountDTO);
        } while (!ballCountDTO.isStrikeout());

        gameView.printGameOverMessage();
    }

    public boolean isRestartGame() {
        gameView.printNewGameMessage();
        String input = gameView.readLine();

        return input.equals("1");
    }

    private List<Integer> readInputNumber() {
        String input = gameView.readLine();
        return convertInputToList(input);
    }

    private boolean checkInputNumber(List<Integer> inputNumbers) {
        Set<Integer> setInputNumbers = new HashSet<>(inputNumbers);

        return inputNumbers.size() == Constants.NUMBER_OF_NUMBERS && setInputNumbers.size() == inputNumbers.size();
    }

    private List<Integer> convertInputToList(String input) {
        List<Integer> inputNumbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            inputNumbers.add(Character.getNumericValue(input.charAt(i)));
        }

        return inputNumbers;
    }
}
