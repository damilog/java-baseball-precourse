package baseball;

import java.util.ArrayList;
import nextstep.utils.Randoms;

public class ComputerPlayer {

    public ArrayList<Integer> getRandomNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();

        while (randomNumbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(num)) {
                randomNumbers.add(num);
            }
        }
        return randomNumbers;
    }

}
