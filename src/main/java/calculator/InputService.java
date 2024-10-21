package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputService {

    public static String readLine() {
        System.out.println("숫자가 포함된 문자열을 입력하세요: ");
        String input = changeEmptyToZero(Console.readLine());

        return input;
    }

    private static String changeEmptyToZero(String input) {
        return input.isEmpty() ? "0" : input;
    }

}
