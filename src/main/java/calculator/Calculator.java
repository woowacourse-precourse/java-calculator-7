package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해주세요.\n";
    private static final String OUTPUT_MESSAGE = "결과 : ";

    private String input;
    private int result = 0;
    private String[] separators = {".", ":"};
    private String[] numbers;

    public Calculator() {
        System.out.print(INPUT_MESSAGE);
        this.input = Console.readLine().trim();
        parse();
        calculate();
    }

    public Calculator(String input) {
        this.input = input.trim();
        parse();
        calculate();
    }

    private void parse() {
        int startIndex = input.indexOf("//") + 2;
        int endIndex = input.indexOf("\\n");
        String target;

        if (startIndex == 2 && startIndex < endIndex) {
            target = input.substring(startIndex, endIndex);
            parseSeparator(target);
            target = input.substring(endIndex + 2);
        } else if (startIndex == 1 && endIndex == -1) {
            target = input;
        } else {
            throw new IllegalArgumentException();
        }
        parseNumber(target);
    }

    private void parseSeparator(String input) {
        String[] newSeparators = new String[separators.length + input.length()];
        String[] customSeparators = input.split("");

        System.arraycopy(separators, 0, newSeparators, 0, separators.length);
        System.arraycopy(customSeparators, 0, newSeparators, separators.length, customSeparators.length);
        separators = newSeparators;
    }

    private void parseNumber(String input) {
        for (int i = 0; i < separators.length; i++) {
            separators[i] = "\\" + separators[i];
        }
        String regex = String.join("|", separators);
        numbers = input.split(regex);
    }

    private void calculate() {
        for (String number : numbers) {
            try {
                result = result + Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
