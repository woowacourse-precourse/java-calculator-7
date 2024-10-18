package calculator;

import calculator.dto.Data;
import calculator.parser.ParseManager;

public class Calculator {

    public static void run() {
        ParseManager parseManager = new ParseManager();
        try {
            String inputData = InputDataReader.getInputData();
            Data data = parseManager.parseData(inputData);
            int result = sum(data);
            Logger.printResult(result);
        } finally {
            InputDataReader.close();
        }
    }

    private static int sum(Data data) {
        int sum = 0;
        long longSum = 0;

        String contents = data.getContents();
        String separators = data.getSeparators();
        String[] nums = contents.split(separators);

        try {
            for (int i = 0; i < nums.length; i++) {
                sum += Integer.parseInt(nums[i]);
                longSum += Integer.parseInt(nums[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (sum != longSum) {
            throw new IllegalArgumentException();
        }

        return sum;
    }
}
