package calculator;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputClass {

    private final String LEFT_CUSTOM_SEPARATOR = "//";
    private final String RIGHT_CUSTOM_SEPARATOR = "\\n";
    private static final String INPUT_SENTENCE = "덧셈할 문자열을 입력해 주세요.";
    private CalculatorService calculatorService;

    /*public InputClass(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }*/


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
        if ((inputText.contains(LEFT_CUSTOM_SEPARATOR)) && (inputText.contains(RIGHT_CUSTOM_SEPARATOR))) {
            return false;
        }
        return true;
    }
}
