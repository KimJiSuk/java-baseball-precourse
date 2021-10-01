package baseball;

public class GameController {
    GameService gameService = new GameService();

    public void run() {
        do {
            gameService.generateGame();
            gameService.startGame();
        } while (gameService.isRestartGame());
    }

}
