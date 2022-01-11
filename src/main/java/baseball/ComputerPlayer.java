package baseball;

import java.util.ArrayList;
import nextstep.utils.Randoms;

public class ComputerPlayer {

    private static final int MAX_PITCH_COUNT = 3;

    public ArrayList<Integer> getRandomNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < MAX_PITCH_COUNT) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(num)) {
                randomNumbers.add(num);
            }
        }
        return randomNumbers;
    }

}
