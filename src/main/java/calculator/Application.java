package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputVal = Console.readLine();
        System.out.println("inputVal = " + inputVal);
        Console.close();
        String[] parseStringArray = ArrayFunction.parseNumbersFromString(inputVal);
        System.out.println("parseStringArray = " + Arrays.toString(parseStringArray));
    }
}
