package calculator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static ArrayList<String> seperatorList = new ArrayList<>(List.of(".", ":"));
    public static String userInput;
    public static ArrayList<String> userNumList = new ArrayList<String>();

    public static void getCustomSeperator(String input) {
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
            userInput = userInput.substring((input.indexOf("\\n") + 2));
        }
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        return userInput;
    }

    public static boolean isNumber(String input) {
        return input.matches("\\d");
    }

    public static void getNumber(String userInput) {
        StringBuilder numberBuffer = new StringBuilder();
        for (int i = 0; i < userInput.length(); i++) {
            String curChar = userInput.substring(i, i + 1);
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

    public static void addNum() {
        BigInteger answer = BigInteger.ZERO;
        for (String s : userNumList) {
            answer = answer.add(convertStringToBigInt(s));
        }
        System.out.println("결과 : " + answer);
    }

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해주세요");
        userInput = getUserInput();
        getCustomSeperator(userInput);
        getNumber(userInput);
        addNum();
    }
}