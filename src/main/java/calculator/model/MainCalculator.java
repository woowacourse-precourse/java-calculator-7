package calculator.model;

import calculator.addCalculator.AddCalculator;
import calculator.stringSplitter.StringContoller;
import camp.nextstep.edu.missionutils.Console;

public class MainCalculator {
    private final AddCalculator addCalculator;
    private final StringContoller stringContoller;
    public MainCalculator(AddCalculator addCalculator, StringContoller contoller) {
        this.addCalculator = addCalculator;
        this.stringContoller = contoller;
    }

    public void run(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = stringContoller.splitsString(input);
        int result = addCalculator.calculateSum(numbers);
        System.out.println("결과 : " + result);
    }

}
