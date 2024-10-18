package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {

    static Boolean errorFlag = false;

    private static String extractCustomSeparation(String inputStr) {
        if (inputStr.startsWith("//")) { //\n이 구분자일 경우도 생각해봐야함.
            int endIndex = inputStr.indexOf("n");
            if (endIndex != -1) {
                return inputStr.substring(2, endIndex - 1);
            }
        }
        return null;
    }

    private static String[] extractToken(String inputStr, String separations) {
        ArrayList<Integer> listInt = new ArrayList<Integer>();

        separations = "[" + separations + "]";
        String[] tokens = inputStr.split(separations);
        return tokens;
    }

    private static ArrayList<Integer> extractIntegerAndDetectChar(String[] tokens) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            System.out.println("token = " + token);
            if (isDigit(token)) {
                numbers.add(Integer.parseInt(token));
            } else {
                errorFlag = true;
//                break;
            }
        }
        return numbers;
    }

    private static boolean isDigit(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//         TODO: 프로그램 구현
        try {
            String inputStr = Console.readLine();
//          "//;\n1;2;3,4:5,q", "//;\n1;2;3,4:5";
            String separations = ",:";

            String customSeparation = extractCustomSeparation(inputStr);
            separations += customSeparation;

            if (customSeparation != null) {
//            System.out.println(customSeparation);
                int SeparationEndIndex = inputStr.indexOf("n");
                inputStr = inputStr.substring(SeparationEndIndex + 1);
            }
            String[] tokens = extractToken(inputStr, separations);
            ArrayList<Integer> integers = extractIntegerAndDetectChar(tokens);
            if (errorFlag) {
                throw new IllegalArgumentException();
            }
            int sum = integers.stream().mapToInt(Integer::intValue).sum();
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: 잘못된 입력입니다.");
            System.exit(1);
        }

    }
}
