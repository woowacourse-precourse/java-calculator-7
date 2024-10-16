package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public String[] removeSeparators(String removedDeclarePart, Character customSeparator) {
        String regex = "[,|:|" + customSeparator + "]";
        String[] removedSeparatorsArray = removedDeclarePart.split(regex);

        return removedSeparatorsArray;
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
        return 0;
    }

    public static void main(String[] args) {
        Application T = new Application();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        int sum = T.calculateSum(input);
        System.out.println("결과 : " + sum);
    }
}
