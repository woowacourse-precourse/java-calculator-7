package calculator.domain;

import calculator.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final InputView inputView;
    private static final Integer PREFIX_DIVISION_INDEX = 2;
    private static final Integer NEXT_DIVISION_INDEX = 3;
    private static final Integer START_NUMBER_INDEX = 5;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public int calculateNumber(){
        inputView.inputSentence();
        int num = 0;
        String input = Console.readLine();
        if(input.equals("")) return 0;

        String customDivision = extractDivision(input);
        checkInputString(input, customDivision);

        String[] numbers = splitString(input, customDivision);

        return num;
    }

    public String extractDivision(String input) {
        if (input.startsWith("/")) {
            return input.substring(PREFIX_DIVISION_INDEX, NEXT_DIVISION_INDEX);
        }
        return "";
    }

    public void checkInputString(String input, String customDivision) {
        if (customDivision.isEmpty()) {
            if (checkOtherDivision(input, customDivision)) {
                throw new IllegalArgumentException("기본 구분자 외 구분자가 포함되어있습니다.");
            }
        } else {
            if (input.substring(PREFIX_DIVISION_INDEX, NEXT_DIVISION_INDEX + 1).equals("\\n")) {
                throw new IllegalArgumentException("커스텀 구분자가 누락되었습니다.");
            } else if (checkOtherDivision(input, customDivision)) {
                throw new IllegalArgumentException("커스텀 구분자 외 구분자가 포함되어있습니다.");
            }
        }
    }

    public boolean checkOtherDivision(String input, String customDivision) {
        if (customDivision.isEmpty()) {
            for (char ch : input.toCharArray()) {
                if (!Character.isDigit(ch) && ch != ';' && ch != ':') {
                    return true;
                }
            }
        } else {
            input = input.substring(START_NUMBER_INDEX);
            for (char ch : input.toCharArray()) {
                if (!Character.isDigit(ch) && customDivision.charAt(0) != ch) {
                    return true;
                }
            }
        }
        return false;
    }

    public String[] splitString(String input, String customDivision) {
        String[] numbers;
        if (customDivision.isEmpty()) {
            numbers = input.split(",|:");
        } else {
            input = input.substring(START_NUMBER_INDEX);
            numbers = input.split(customDivision);
        }
        return numbers;
    }
}
