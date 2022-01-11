package baseball;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();

        while (gameController.getIsPlayGame()) {
            gameController.playGame();
        }
    }

}
