package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {

    public void checkSeparatorException(String input){
        if (input.startsWith("//")) {
            int customSeparatorNextIndex = input.indexOf("\n");
            if (customSeparatorNextIndex == -1) {
                throw new IllegalArgumentException("구분자 형식 오류: 구분자 선언부에 '\\n'이 없습니다.");
            }
            String delimiterPart = input.substring(2, customSeparatorNextIndex);
            if (delimiterPart.length() != 1) {
                throw new IllegalArgumentException("구분자 형식 오류: 구분자는 반드시 하나의 문자여야 합니다.");
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

    public List<Integer> parseStringToInteger(String[] removedSeparatorsArray){
        List<Integer> parsedIntegers = new ArrayList<>();
        for (String number : removedSeparatorsArray){
            if (!number.isEmpty()) {
                try {
                    int num = Integer.parseInt(number.trim());
                    if (num < 0) {
                        throw new IllegalArgumentException("입력 값에 음수가 포함될 수 없습니다: " + number);
                    }
                    parsedIntegers.add(num);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 숫자 입력입니다: " + number);
                }
            }
        }
        return parsedIntegers;
    }

    public String[] removeSeparators(String removedDeclarePart, Character customSeparator) {
        String regex;
        if (customSeparator == null) {
            regex = "[,:]";
        } else {
            regex = "[,:" + Pattern.quote(customSeparator.toString()) + "]";
        }

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
        checkSeparatorException(input);

        if (!input.startsWith("//")) {
            return null;
        }
        return input.charAt(2);
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

        try {
            int sum = T.calculateSum(input);
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
