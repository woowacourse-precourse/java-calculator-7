package calculator;

import calculator.parser.ParseManager;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        ParseManager parseManager = new ParseManager();

        try {
            String inputData = InputDataReader.getInputData();
            List<Integer> numbers = parseManager.parseData(inputData);
            int result = Calculator.sum(numbers);
            Logger.printResult(result);
        } finally {
            InputDataReader.close();
        }
    }
}
