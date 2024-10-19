package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static String getCustomSeperator(String input, ArrayList<String> seperatorList) {
        String customSeperator;
        if (input.contains("\\n") && input.contains("//")) {
            customSeperator = input.substring(input.indexOf("//") + 2, input.indexOf("\\n"));
            if (customSeperator.length() > 1) {
                throw new IllegalArgumentException("한개의 커스텀 구분자만 추가할 수 있습니다.");
            }
            if (input.indexOf("//") != 0) {
                throw new IllegalArgumentException("커스텀 구분자는 문자열 처음에서만 추가할 수 있습니다.");
            }
            seperatorList.add(customSeperator);
            return input.substring((input.indexOf("\\n") + 2));
        }
        return input;
    }

    public static void checkCustomSeparatorCount(String input, String customSeperatorKeyword) {
        int index = 0;
        int keyworkdCount = 0;
        while ((index = input.indexOf(customSeperatorKeyword, index)) != -1) {
            keyworkdCount++;
            if (keyworkdCount > 1) {
                throw new IllegalArgumentException("//와 \\n는 한 번만 사용될 수 있습니다.");
            }
            index += customSeperatorKeyword.length();
        }
    }

    public static String getUserInput() {
        userInput = Console.readLine();
        return userInput;
    }

    public static boolean isNumber(String input) {
        return input.matches("\\d");
    }

    public static void getNumber(String cleanInput, ArrayList<String> seperatorList, ArrayList<String> userNumList) {
        StringBuilder numberBuffer = new StringBuilder();
        for (int i = 0; i < cleanInput.length(); i++) {
            String curChar = cleanInput.substring(i, i + 1);
            if (seperatorList.contains(curChar)) {
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

    public static void addNum(ArrayList<String> userNumList) {
        BigInteger answer = BigInteger.ZERO;
        for (String s : userNumList) {
            answer = answer.add(convertStringToBigInt(s));
        }
        System.out.println("결과 : " + answer);
    }

    public static void main(String[] args) {
        ArrayList<String> seperatorList = new ArrayList<>(List.of(".", ":"));
        String userInput, cleanInput;
        ArrayList<String> userNumList = new ArrayList<String>();

        System.out.println("덧셈할 문자열을 입력해주세요");
        userInput = getUserInput();
        checkCustomSeparatorCount(userInput, "//");
        checkCustomSeparatorCount(userInput, "\\n");
        cleanInput = getCustomSeperator(userInput, seperatorList);
        getNumber(cleanInput, seperatorList, userNumList);
        addNum(userNumList);
    }
}