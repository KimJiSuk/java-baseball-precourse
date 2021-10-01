package baseball;

public final class Constants {
    public static final int NUMBER_OF_NUMBERS = 3;
    public static final int LOW_NUMBER = 1;
    public static final int HIGH_NUMBER = 9;

    public static final String START_COMMAND = "1";
    public static final String STOP_COMMAND = "2";

    public static final String GAME_OVER_MESSAGE = NUMBER_OF_NUMBERS + "개의 숫자를 모두 맞히셨습니다! 게임 끝";
    public static final String NEW_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼";
    public static final String INPUT_ERROR_MESSAGE = "[ERROR] 서로 다른 " + NUMBER_OF_NUMBERS + "자리 숫자를 입력 해주세요.";
    public static final String RESTART_ERROR_MESSAGE =
            "[ERROR] " + START_COMMAND + " or " + STOP_COMMAND + " 를 입력 해주세요.";

}
