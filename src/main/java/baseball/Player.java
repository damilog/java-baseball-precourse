package baseball;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Player {

    public static int INPUT_LENGTH = 3;

    public List<Integer> getPlayerNumber() {
        System.out.println("숫자를 입력해주세요");
        Scanner scanner = new Scanner(System.in);

        List<Integer> playerNumbers = new ArrayList<>();
        String input = scanner.next();
        isValidLength(input);

        for (String number : input.split("")) {
            playerNumbers.add(Integer.parseInt(number));
        }

        return playerNumbers;
    }

    public void isValidLength(String s) {
        if (s.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("세 자리 수가 아님!!");
        }
    }
}
