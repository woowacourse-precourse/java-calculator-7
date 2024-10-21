package util;

import Delimiter.BasicDelimiter;
import Delimiter.CustomDelimiter;
import Delimiter.DelimiterHandler;
import view.InputView;
import view.OutputView;

public class Calculator {

    public void run() {
        String input = InputView.readLine();
        Validator.isEmpty(input);
        String delimiterType = DelimiterHandler.detectDelimiterType(input);
        if (delimiterType.equals("Basic")) {
            int result = Calculator.getSum(BasicDelimiter.getNumber(input));
            OutputView.printResult(result);
            return;  // Basic 구분자가 처리되면 일찍 종료
        }
        // Custom 구분자 처리
        int result = getSum(CustomDelimiter.getNumber(input));
        OutputView.printResult(result);
    }

    public static int getSum(int[] numbers) {
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }
}
