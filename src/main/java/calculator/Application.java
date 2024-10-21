package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static String customSeparatorKeywordStart = "//";
    private static String customSeparatorKeywordEnd = "\\n";
    private static int customSeparatorKeywordEndIndex = 3;

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
        boolean hasValidSeparatorStart = checkCustomSeparatorStartKeyword(input, customSeparatorKeywordStart);
        boolean hasValidSeparatorEnd = checkCustomSeparatorEndKeyWord(input, customSeparatorKeywordEnd);

        if (hasValidSeparatorStart && !hasValidSeparatorEnd) {
            if (!input.contains(customSeparatorKeywordEnd)) {
                throw new IllegalArgumentException("커스텀 구분자 시작 문자가 입력되었지만, 종료 문자가 없습니다.");
            }
            if (input.indexOf(customSeparatorKeywordEnd) != customSeparatorKeywordEndIndex) {
                throw new IllegalArgumentException("커스텀 구분자는 1개만 추가할 수 있습니다.");
            }
        }
        if (!hasValidSeparatorStart && !hasValidSeparatorEnd) {
            return input;
        }

        return input.substring(customSeparatorKeywordEndIndex + 2);
    }

    public static boolean checkCustomSeparatorStartKeyword(String input, String customSeparatorKeywordStart) {
        return input.startsWith(customSeparatorKeywordStart);
    }

    public static boolean checkCustomSeparatorEndKeyWord(String input, String customSeparatorKeyword) {
        return input.indexOf(customSeparatorKeyword) == customSeparatorKeywordEndIndex;
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