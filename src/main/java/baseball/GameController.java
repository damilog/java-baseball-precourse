package baseball;

import java.util.ArrayList;
import nextstep.utils.Console;

public class GameController {

    private boolean isPlayGame = true;
    private int strike = 0;
    private int ball = 0;

    public void playGame() {
        Player player = new Player();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        ArrayList<Integer> computerPlayerPitches = computerPlayer.getRandomNumbers();

        while (strike < 3) {
            resetScore();
            ArrayList<Integer> playerNumbers = player.getPlayerPitches();
            judgePitches(playerNumbers, computerPlayerPitches);
            printPitchResult();
        }
    }

    public boolean getIsPlayGame() {
        return isPlayGame;
    }

    private void setGamePlay() {
        isPlayGame = true;
    }

    private void setGameEnd() {
        isPlayGame = false;
    }

    private void printPitchResult() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strike == 3) {
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            setGameEnd();
            restartByPlayerInput();

            return;
        }

        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }

        if (ball > 0) {
            System.out.println(ball + "볼");
        }
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void restartGame() {
        setGamePlay();
        resetScore();
    }

    private void restartByPlayerInput() {
        System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
        String playerPitch = Console.readLine();
        checkPlayerPitch(playerPitch);
    }

    private void checkPlayerPitch(String playerPitch) {
        if (playerPitch.equals("1")) {
            restartGame();
        }
        if (playerPitch.equals("2")) {
            System.out.println("게임 끝");
        }
    }

    private void judgePitches(ArrayList<Integer> playerPitches,
        ArrayList<Integer> computerPlayerPitches) {

        for (int i = 0; i < playerPitches.size(); i++) {
            int playerPitch = playerPitches.get(i);
            updatePitchResult(playerPitch, computerPlayerPitches, i);
        }
    }

    private void updatePitchResult(int playerPitch, ArrayList<Integer> computerPlayerPitches,
        int index) {
        if (checkStrike(playerPitch, computerPlayerPitches, index)) {
            strike++;
        }

        if (checkBall(playerPitch, computerPlayerPitches, index)) {
            ball++;
        }
    }

    private boolean checkStrike(int playerPitch, ArrayList<Integer> computerPlayerPitches,
        int index) {
        return playerPitch == computerPlayerPitches.get(index);
    }

    private boolean checkBall(int playerPitch, ArrayList<Integer> computerPlayerPitches,
        int index) {
        return computerPlayerPitches.contains(playerPitch)
            && computerPlayerPitches.get(index) != playerPitch;
    }
}
