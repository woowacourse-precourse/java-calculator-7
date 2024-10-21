package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Application {

    private static String customSeparatorKeywordStart = "//";
    private static String customSeparatorKeywordEnd = "\\n";
    private static int customSeparatorKeywordEndIndex = 3;

    public static void main(String[] args) {
        Set<Character> separatorList = new HashSet<>('.', ':');

        System.out.println("덧셈할 문자열을 입력해주세요");
        String userInput = getUserInput();
        ArrayList<String> numberTexts = getNumberTextFromInputDividedBySeparators(userInput, separatorList);
        String answer = getSumOfNumberTexts(numberTexts);
        System.out.println("결과 : " + answer);
    }

    private static ArrayList<String> getNumberTextFromInputDividedBySeparators(String input,
                                                                               Set<Character> separatorList) {
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
            return getNumberTexts(input, separatorList);
        }
        separatorList.add(extractCustomSeparator(input));
        return getNumberTexts(input.substring(customSeparatorKeywordEndIndex + 2), separatorList);
    }

    private static boolean checkCustomSeparatorStartKeyword(String input, String customSeparatorKeywordStart) {
        return input.startsWith(customSeparatorKeywordStart);
    }

    private static boolean checkCustomSeparatorEndKeyWord(String input, String customSeparatorKeyword) {
        return input.indexOf(customSeparatorKeyword) == customSeparatorKeywordEndIndex;
    }

    private static char extractCustomSeparator(String input) {
        validateKeywordIncludeOnce(input, customSeparatorKeywordStart);
        validateKeywordIncludeOnce(input, customSeparatorKeywordEnd);

        return input.charAt(customSeparatorKeywordEndIndex - 1);
    }

    private static ArrayList<String> getNumberTexts(String input, Set<Character> separatorList) {
        ArrayList<String> numberTexts = new ArrayList<>();
        StringBuilder currentNumberBuilder = new StringBuilder();

        for (char inputCharacter : input.toCharArray()) {
            boolean isNumber = Character.isDigit(inputCharacter);
            boolean isSeparator = separatorList.contains(inputCharacter);

            if (!isNumber && !isSeparator) {
                throw new IllegalArgumentException("구분자, 숫자 이외의 문자는 입력할 수 없습니다.");
            }

            if (isSeparator) {
                numberTexts.add(currentNumberBuilder.toString());
                currentNumberBuilder.setLength(0);
            }

            if (isNumber) {
                currentNumberBuilder.append(inputCharacter);
            }
        }

        if (!currentNumberBuilder.isEmpty()) {
            numberTexts.add(currentNumberBuilder.toString());
        }

        return numberTexts;
    }

    private static void validateKeywordIncludeOnce(String input, String keyword) {
        if (input.indexOf(keyword) != input.lastIndexOf(keyword)) {
            throw new IllegalArgumentException("//와 \\n는 한 번만 사용될 수 있습니다.");
        }
    }

    private static String getUserInput() {
        String input = Console.readLine();
        Console.close();
        return input;
    }


    private static String getSumOfNumberTexts(ArrayList<String> userNumList) {
        BigInteger answer = BigInteger.ZERO;
        for (String numberText : userNumList) {
            answer = answer.add(new BigInteger(numberText));
        }
        return answer.toString();
    }
}