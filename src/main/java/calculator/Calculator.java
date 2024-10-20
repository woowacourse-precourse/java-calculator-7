package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Calculator {

    public Set<String> delimiters = new HashSet<>(Arrays.asList(",", ":"));

    public int add(String input) {
        isNothing(input);
        String stringInput = checkCustomDelimiter(input);
        String[] numbers = splitNumbers(stringInput);
        checkForNegativeNumbers(numbers);
        return sumNumbers(numbers);
    }

    public String checkCustomDelimiter(String input) {
        input = input.replace("\\n", "\n");

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식입니다. '\\n'이 필요합니다.");
            }
            String customDelimiter = input.substring(2, delimiterEndIndex);
            delimiters.add(customDelimiter);
            return input.substring(delimiterEndIndex + 1);
        }
        return input;
    }

    public String[] splitNumbers(String input) {
        if (input.startsWith("//")) {
            input = input.substring(input.indexOf("\n") + 1);
        }
        String regex = String.join("|", delimiters);  // 구분자들을 단순 연결
        return input.split("[" + regex + "]");
    }

    public int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int value = Integer.parseInt(number);
            sum += value;
        }
        return sum;
    }

    public int isNothing(String input) {
        if (input.equals("")) {
            return 0;
        }
        return -1;
    }

    public void checkForNegativeNumbers(String[] numbers) {
        List<String> negativeNumbers = new ArrayList<>();

        for (String number : numbers) {
            int value = Integer.parseInt(number);
            if (value < 0) {
                negativeNumbers.add(number);
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");  // 음수 리스트 출력
        }
    }

}
