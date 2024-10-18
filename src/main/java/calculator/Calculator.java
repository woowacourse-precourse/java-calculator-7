package calculator;

import calculator.parser.ParseManager;
import java.util.List;

public class Calculator {

    public static void run() {
        ParseManager parseManager = new ParseManager();
        try {
            String inputData = InputDataReader.getInputData();
            List<Integer> numbers = parseManager.parseData(inputData);
            int result = sum(numbers);
            Logger.printResult(result);
        } finally {
            InputDataReader.close();
        }
    }

    private static int sum(List<Integer> numbers) {
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
