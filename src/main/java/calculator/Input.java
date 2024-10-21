package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Input {
    private static String input;
    public static void readLine(){
        input = Console.readLine(); // 입력 읽기
    }

    public static String getInput(){
        return input;
    }
}
