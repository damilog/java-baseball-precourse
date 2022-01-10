package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import nextstep.utils.Randoms;

public class GameController {
    private static boolean isPlayGame = true;
    private static int strike = 0;
    private static int ball = 0;

    public void playGame(){
        Player player = new Player();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        ArrayList<Integer> computerPlayerPitches = computerPlayer.getRandomNumbers();

        while(strike < 3){
            resetScore();
            ArrayList<Integer> playerNumbers = player.getPlayerPitches();
            judgePitches(computerPlayerPitches, playerNumbers);
            printPitchResult();
        }
    }

    public boolean  getIsPlayGame(){
        return isPlayGame;
    }

    private void setGamePlay(){
        isPlayGame = true;
    }

    private void setGameEnd(){
        isPlayGame = false;
    }

    private void printPitchResult () {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strike > 0) System.out.println("스트라이크 " + strike);

        if (strike > 0) {
            System.out.println(strike + "스트라이크");
        }

        if (ball > 0) {
            System.out.println(ball + "볼");
        }
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }

    private void judgePitches( ArrayList<Integer> playerPitches, ArrayList<Integer> computerPlayerPitches){
        for(int i = 0; i < playerPitches.size(); i++){
            int playerPitch = playerPitches.get(i);
            updatePitchResult(playerPitch,computerPlayerPitches,i);
        }
    }

    private void updatePitchResult (int playerPitch,ArrayList<Integer> computerPlayerPitches, int index){
        if(checkStrike(playerPitch,computerPlayerPitches,index)){
            strike++;
        }

        if(checkBall(playerPitch,computerPlayerPitches,index)){
            ball++;
        }
    }

    private boolean checkStrike(int playerPitch,ArrayList<Integer> computerPlayerPitches, int index){
        return playerPitch == computerPlayerPitches.get(index);
    }

    private boolean checkBall(int playerPitch,ArrayList<Integer> computerPlayerPitches, int index) {
        return computerPlayerPitches.contains(playerPitch) && computerPlayerPitches.get(index) != playerPitch;
    }
}
