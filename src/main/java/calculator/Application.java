package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static String extractCustomSeparation(String inputStr) {
        if (inputStr.startsWith("//")) {
            int endIndex = inputStr.indexOf("n");
            if (endIndex != -1) {
                return inputStr.substring(2, endIndex - 1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
//         TODO: 프로그램 구현
        String inputStr = Console.readLine();
//        String inputStr = "//;\n1;2;3";
        ArrayList<Integer> listInt = new ArrayList<Integer>();

        String customSeparation = extractCustomSeparation(inputStr);
        if (customSeparation != null) {
            System.out.println(customSeparation);
        }
    }
}
