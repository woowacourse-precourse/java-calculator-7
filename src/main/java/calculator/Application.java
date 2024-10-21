package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        new Application().run();
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String[] splitInput = splitInput(input);
        System.out.println("결과 : " + getSum(splitInput));
    }

    public String[] splitInput(String input) {
        Matcher matcher = Pattern.compile("//(.*)\\\\n(.*)").matcher(input);
        boolean isMatched = matcher.find();
        String delimiter = "[,:" + (isMatched ? matcher.group(1) : "") + "]";
        String numbers = isMatched ? matcher.group(2) : input;
        return new String[]{delimiter, numbers};
    }

    public Integer getSum(String[] splitInput) {
        String delimiter = splitInput[0];
        String numbers = splitInput[1];
        return Arrays.stream(numbers.split(delimiter))
                .map(this::convertToNum)
                .reduce(0, Integer::sum);
    }

    public int convertToNum(String num) {
        try {
            int parsedNum = Integer.parseInt(num);
            if (parsedNum <= 0) {
                throw new IllegalArgumentException();
            }
            return parsedNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
