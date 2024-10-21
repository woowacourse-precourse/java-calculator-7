package calculator.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요. ");

        String str = "";

        try {
            str = Console.readLine();
        } catch (Exception e) {

        }
        return str;

    }
}