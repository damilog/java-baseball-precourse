package baseball;

import java.util.ArrayList;
import nextstep.utils.Console;

public class Player {
    private static final int MAX_PITCH_COUNT = 3;

    public ArrayList<Integer> getPlayerPitches() {
        ArrayList<Integer> playerPitches = new ArrayList<>();
        System.out.println("숫자를 입력해주세요.");
        String playerPitch = Console.readLine();
        isValidPitchCount(playerPitch);

        for (String pitch : playerPitch.split("")) {
            playerPitches.add(Integer.parseInt(pitch));
        }

        return playerPitches;
    }

    public void isValidPitchCount(String playerPitch) {
        if (playerPitch.length() != MAX_PITCH_COUNT) {
            throw new IllegalArgumentException("세 자리 수를 입력해주세요.");
        }
    }
}
