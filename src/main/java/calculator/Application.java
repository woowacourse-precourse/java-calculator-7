package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {

    public void inputCheckException(String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isDigit(currentChar)) {
                if (Character.getNumericValue(currentChar) < 1) {
                    throw new IllegalArgumentException("숫자는 양수만 가능합니다.");
                }
            }
        }
    }

    public int sumInteger(List<Integer> parsedIntegers) {
        int sumOfIntegers = 0;
        for (int i : parsedIntegers) {
            sumOfIntegers += i;
        }
        return sumOfIntegers;
    }

    public List<Integer> parseStringToInteger(String[] removedSeparatorsArray) {
        List<Integer> parsedIntegers = new ArrayList<>();
        for (String str : removedSeparatorsArray) {
            parsedIntegers.add(Integer.valueOf(str));
        }

        return parsedIntegers;
    }

    public String[] removeSeparators(String removedDeclarePart, Character customSeparator) {
        String regex;
        if (customSeparator == null) {
            // 쉼표(,)와 콜론(:)만 구분자로 사용
            regex = "[,:]";
        } else {
            // 기본 구분자와 커스텀 구분자를 포함한 정규 표현식
            regex = "[,:|" + Pattern.quote(customSeparator.toString()) + "]";
        }
        // 정규 표현식에 따라 문자열을 분리
        return removedDeclarePart.split(regex);
    }


    public String removeDeclarePart(String input, Character customSeparator) {
        if (customSeparator == null) {
            return input;
        }
        else {
            return input.substring(4);
        }
    }


    public Character extractCustomSeparator(String input) {
        if (!input.startsWith("//")) {
            return null;
        }

        String separatorPart = input.substring(2, input.indexOf("\n"));
        if (separatorPart.length() != 1) {
            throw new IllegalArgumentException("구분자는 반드시 하나의 문자여야 합니다.");
        }

        return separatorPart.charAt(0);
    }


    public int calculateSum(String input) {
        Character customSeparator = extractCustomSeparator(input);
        String removedDeclarePart = removeDeclarePart(input, customSeparator);
        String[] removedSeparatorsArray = removeSeparators(removedDeclarePart, customSeparator);
        List<Integer> parsedIntegers = parseStringToInteger(removedSeparatorsArray);
        return sumInteger(parsedIntegers);
    }

    public static void main(String[] args) {
        Application T = new Application();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        input = input.replace("\\n", "\n");

        int sum = T.calculateSum(input);
        System.out.println("결과 : " + sum);
    }
}
