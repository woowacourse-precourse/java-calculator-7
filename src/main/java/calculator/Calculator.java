package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private static final String[] DEFAULT_SEPARATORS = {":", ","};
    private List<String> separators;
    private String numberField;
    private List<Integer> numbers;


    public Calculator(String command) {
        separators = new ArrayList<>();
        command = command.replace("\\n", "\n");
        if (command.equals(" ") || command.isBlank()) {
            numberField = "0";
        } else {
            getNumberField(command);
        }
        separators.add(DEFAULT_SEPARATORS[0]);
        separators.add(DEFAULT_SEPARATORS[1]);
    }

    private void getNumberField(String command) {
        Matcher matcher = Pattern.compile("^//(.)\\n(.*)").matcher(command);
        if (matcher.matches()) {
            String delimiter = Pattern.quote(matcher.group(1));
            separators.add(delimiter);
            this.numberField = matcher.group(2);
        } else {
            numberField = command;
        }
    }

    public int add() {
        splitNumbers();
        int result = 0;
        for (int num : numbers) {
            result += num;
        }
        return result;
    }

    private void splitNumbers() {
        String regex = separators.stream().collect(Collectors.joining("|"));
        String[] split = this.numberField.split(regex);
        numbers = new ArrayList<>();
        for (String number : split) {
            try {
                int temp = Integer.parseInt(number);
                isPositiveNumber(temp);
                numbers.add(temp);
            } catch (NumberCheckException e) {
                throw new IllegalArgumentException("양수가 아닌 값이 들어가 있습니다.");
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 값(구분자, 입력)이 입력됐습니다.");
            }
        }
    }

    private void isPositiveNumber(int num) {
        if (num < 1) {
            throw new NumberCheckException();
        }
    }
}
