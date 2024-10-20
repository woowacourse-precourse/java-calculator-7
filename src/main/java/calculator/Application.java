package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {

    private static String extractCustomSeparation(String inputStr) {
        if (inputStr.startsWith("//")) { //\n이 구분자일 경우도 생각해봐야함. //와 \n 사이에 아무것도 없을 경우
            int endIndex = inputStr.lastIndexOf("\\n");
            if (endIndex != -1) {
                String customSeparation = inputStr.substring(2, endIndex);
                if (!customSeparation.isEmpty()) {
                    return customSeparation;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
        return null;
    }

    private static String[] extractToken(String inputStr, String separations) {
        separations = "[" + separations + "]";
        String[] tokens = inputStr.split(separations);
        return tokens;
    }

    private static ArrayList<Integer> extractIntegerAndDetectChar(String[] tokens) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            if (isDigit(token)) {
                int number = Integer.parseInt(token);
                if (number < 0) { //음수일 경우
                    throw new IllegalArgumentException();
                } else {
                    numbers.add(number);
                }
            } else {
                throw new IllegalArgumentException();
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

    public static void main(String[] args) throws IllegalArgumentException {
//         TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해주세요.");
        String inputStr = Console.readLine();
        String separations = ",:";

        String customSeparation = extractCustomSeparation(inputStr);
        separations += customSeparation;
        System.out.println("customSeparation = " + customSeparation);
        if (customSeparation != null) {
            int SeparationEndIndex = inputStr.indexOf("\\n");
            inputStr = inputStr.substring(SeparationEndIndex + 2);
        }
        String[] tokens = extractToken(inputStr, separations);
        ArrayList<Integer> integers = extractIntegerAndDetectChar(tokens);
        int sum = integers.stream().mapToInt(Integer::intValue).sum();

        System.out.println("결과 : " + sum);
    }
}
