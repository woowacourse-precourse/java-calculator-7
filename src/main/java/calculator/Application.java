package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        ArrayList<String> separatorList = new ArrayList<>(List.of(".", ":"));
        String userInput, cleanInput;
        ArrayList<String> userNumList = new ArrayList<String>();

        System.out.println("덧셈할 문자열을 입력해주세요");
        userInput = getUserInput();
        cleanInput = getNumberTextFromInputDividedBySeparators(userInput, separatorList);
        getNumberTexts(cleanInput, separatorList, userNumList);
        String answer = getSumOfNumberTexts(userNumList);
        System.out.println("결과 : " + answer);

    }

    public static String getNumberTextFromInputDividedBySeparators(String input, ArrayList<String> separatorList) {
        checkCustomSeparatorCount(input, "//");
        checkCustomSeparatorCount(input, "\\n");

        String customSeparator;
        if (input.contains("\\n") && input.contains("//")) {
            customSeparator = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
            if (customSeparator.length() > 1) {
                throw new IllegalArgumentException("한개의 커스텀 구분자만 추가할 수 있습니다.");
            }
            if (input.indexOf("//") != 0) {
                throw new IllegalArgumentException("커스텀 구분자는 문자열 처음에서만 추가할 수 있습니다.");
            }
            separatorList.add(customSeparator);
            return input.substring((input.indexOf("\\n") + 2));
        }
        return input;
    }

    public static void checkCustomSeparatorCount(String input, String customSeparatorKeyword) {
        int index = 0;
        int keyworkdCount = 0;
        while ((index = input.indexOf(customSeparatorKeyword, index)) != -1) {
            keyworkdCount++;
            if (keyworkdCount > 1) {
                throw new IllegalArgumentException("//와 \\n는 한 번만 사용될 수 있습니다.");
            }
            index += customSeparatorKeyword.length();
        }
    }

    public static String getUserInput() {
        String input = Console.readLine();
        Console.close();
        return input;
    }

    public static boolean isNumber(String input) {
        return input.matches("\\d");
    }

    public static void getNumberTexts(String input, ArrayList<String> separatorList, ArrayList<String> userNumList) {
        StringBuilder numberBuffer = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String curChar = input.substring(i, i + 1);
            if (separatorList.contains(curChar)) {
                if (!numberBuffer.isEmpty()) {
                    userNumList.add(numberBuffer.toString());
                    numberBuffer = new StringBuilder();
                }
                continue;
            }
            if (!isNumber(curChar)) {
                throw new IllegalArgumentException("구분자, 양수, //, \\n 이외의 문자는 입력할 수 없습니다.");
            }
            numberBuffer.append(curChar);
        }
        if (!numberBuffer.isEmpty()) {
            userNumList.add(numberBuffer.toString());
        }
    }

    public static BigInteger convertStringToBigInt(String numberString) {
        return new BigInteger(numberString);
    }

    public static String getSumOfNumberTexts(ArrayList<String> userNumList) {
        BigInteger answer = BigInteger.ZERO;
        for (String numberText : userNumList) {
            answer = answer.add(convertStringToBigInt(numberText));
        }
        return answer.toString();
    }
}