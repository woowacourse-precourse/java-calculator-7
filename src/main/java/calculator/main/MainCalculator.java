package calculator.main;

import calculator.addCalculator.AddCalculator;
import calculator.stringSplitter.StringSplitter;
import camp.nextstep.edu.missionutils.Console;

public class MainCalculator {
    private final AddCalculator addCalculator;
    private final StringSplitter stringSplitter;

    private MainCalculator(AddCalculator addCalculator, StringSplitter stringSplitter) {
        this.addCalculator = addCalculator;
        this.stringSplitter = stringSplitter;
    }

    public void run(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String[] numbers = stringSplitter.splitsString(input);
        int result = addCalculator.calculateSum(numbers);
        System.out.println("결과 : " + result);
    }

}
