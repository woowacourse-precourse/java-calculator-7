package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static String extractCustomSeparation(String inputStr) {
        if (inputStr.startsWith("//")) { //\n이 구분자일 경우도 생각해봐야함.
            int endIndex = inputStr.indexOf("n");
            if (endIndex != -1) {
                return inputStr.substring(2, endIndex - 1);
            }
        }
        return null;
    }

    private static String[] extractInteger(String inputStr, String separations) {
        ArrayList<Integer> listInt = new ArrayList<Integer>();

        separations = "[" + separations + "]";
        String[] tokens = inputStr.split(separations);
        System.out.println("tokens = " + Arrays.toString(tokens));
        return tokens;
    }

    public static void main(String[] args) {
//         TODO: 프로그램 구현
        String inputStr = Console.readLine();
//        String inputStr = "//;\n1;2;3";
        String separations = ",;";

        String customSeparation = extractCustomSeparation(inputStr);
        separations += customSeparation;


        if (customSeparation != null) {
//            System.out.println(customSeparation);
            int SeparationEndIndex = inputStr.indexOf("n");
            inputStr = inputStr.substring(SeparationEndIndex + 1);
        }

        String[] strings = extractInteger(inputStr, separations);
    }
}
