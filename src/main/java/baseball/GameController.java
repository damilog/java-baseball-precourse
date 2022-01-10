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
        }
    }

    public boolean isPlayGame(){
        return strike != 3;
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
