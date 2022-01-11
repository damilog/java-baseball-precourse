package baseball;

import java.util.ArrayList;
import nextstep.utils.Console;

public class Player {

    private static final int MAX_PITCH_COUNT = 3;

    public ArrayList<Integer> getPlayerPitches() {
        ArrayList<Integer> playerPitches = new ArrayList<>();
        System.out.println("숫자를 입력해주세요.");
        String playerPitch = Console.readLine();
        for (String pitch : playerPitch.split("")) {
            playerPitches.add(Integer.parseInt(pitch));
        }
        return playerPitches;
    }

    public boolean checkPlayerPitch(ArrayList<Integer> playerPitches) {
        try {
            if (!checkPitchCount(playerPitches)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException error) {
            System.out.println("[ERROR] 3자리 수를 입력해주세요.");
            return false;
        }
        return true;
    }

    private boolean checkPitchCount(ArrayList<Integer> playerPitches) {
        return playerPitches.size() == MAX_PITCH_COUNT;
    }


}
