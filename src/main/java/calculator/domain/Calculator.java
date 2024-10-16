package calculator.domain;

import calculator.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private final InputView inputView;
    private static final Integer PREFIX_DIVISION_INDEX = 2;
    private static final Integer NEXT_DIVISION_INDEX = 3;

    public Calculator(InputView inputView) {
        this.inputView = inputView;
    }

    public int calculateNumber(){
        inputView.inputSentence();
        int num = 0;
        String input = Console.readLine();
        if(input.equals("")) return 0;

        String customDivision = extractDivision(input);

        return num;
    }

    public String extractDivision(String input) {
        if (input.startsWith("/")) {
            return input.substring(PREFIX_DIVISION_INDEX, NEXT_DIVISION_INDEX);
        }
        return "";
    }
}
