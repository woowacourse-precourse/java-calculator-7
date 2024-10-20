package calculator.helper;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class IOHelper {


    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static void printResult(int result) {
        System.out.println("결과 : " + result);
    }

}
