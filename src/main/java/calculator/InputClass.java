package calculator;

import calculator.domain.Calculator;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputClass {

    private final String LEFT_CUSTOM_SEPARATOR = "//";
    private final String RIGHT_CUSTOM_SEPARATOR = "\\n";
    private final String COMMA = ",";
    private final String COLON = ":";
    private final String INPUT_SENTENCE = "덧셈할 문자열을 입력해 주세요.";

    public String input() {
        try {
            System.out.println(INPUT_SENTENCE);
            Scanner scanner = new Scanner(System.in);
            String inputText = scanner.nextLine();
            return inputText;
        } catch (NoSuchElementException e) {
        }
        return "";
    }

    public Boolean existCustomSeparator(String inputText) {
        if ((inputText.contains(LEFT_CUSTOM_SEPARATOR)) && (inputText.contains(RIGHT_CUSTOM_SEPARATOR))) {
            return true;
        }
        return false;
    }

    public Boolean existOriginalSeparator(String inputText) {
        if ((inputText.contains(COMMA)) || (inputText.contains(COLON))) {
            return true;
        }
        return false;
    }

    public Boolean isInputBlank(String inputText) {
        if (inputText.length() == 0) {
            return true;
        }
        return false;
    }

    public Boolean checkOnlyNumber(String inputText) {
        if (inputText.length() == 1) {
            try {
                Integer.parseInt(inputText);
                return true;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        return false;
    }
}
