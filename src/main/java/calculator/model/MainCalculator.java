package calculator.model;

import calculator.addCalculator.AddCalculator;
import calculator.stringSplitter.StringController;
import camp.nextstep.edu.missionutils.Console;

public class MainCalculator {
    private final AddCalculator addCalculator;
    private final StringController stringController;
    public MainCalculator(AddCalculator addCalculator, StringController controller) {
        this.addCalculator = addCalculator;
        this.stringController = controller;
    }

    public void run(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = stringController.splitsString(input);
        int result = addCalculator.calculateSum(numbers);
        System.out.println("결과 : " + result);
    }

}
