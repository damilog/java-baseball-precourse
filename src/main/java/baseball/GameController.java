package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import nextstep.utils.Randoms;

public class GameController {
    private static int strike = 0;
    private static int ball = 0;

    public void playGame(){
        Player player = new Player();

        ComputerPlayer computerPlayer = new ComputerPlayer();
        ArrayList<Integer> computerPlayerNumbers = computerPlayer.getRandomNumbers();
        System.out.println(computerPlayerNumbers);

        while(strike < 3){
            ArrayList<Integer> playerNumbers = player.getPlayerNumber();
            judgePitches(computerPlayerNumbers, playerNumbers);
            printPitchResult();
        }
    }

    public boolean isPlayGame(){
        return strike != 3;
    }

    public void printPitchResult () {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strike > 0) System.out.println("스트라이크 " + strike);

        if (ball > 0) System.out.println("볼" + ball);
    }

    private void judgePitches( ArrayList<Integer> playerPitches, ArrayList<Integer> computerPlayerPitches){
        for(int i = 0; i < playerPitches.size(); i++){
            int playerPitch = playerPitches.get(i);
            updatePitchResult(playerPitch,computerPlayerPitches,i);
        }
    }

    private void updatePitchResult (int playerPitch,ArrayList<Integer> computerPlayerPitches, int index){
        if(isStrike(playerPitch,computerPlayerPitches,index)){
            strike++;
        }

        if(isBall(playerPitch,computerPlayerPitches,index)){
            ball++;
        }
    }

    private boolean isStrike(int playerPitch,ArrayList<Integer> computerPlayerPitches, int index){
        return playerPitch == computerPlayerPitches.get(index);
    }

    private boolean isBall(int playerPitch,ArrayList<Integer> computerPlayerPitches, int index) {
        return computerPlayerPitches.contains(playerPitch)
            && computerPlayerPitches.indexOf(playerPitch) > -1;
    }
}
