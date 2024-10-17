package calculator;

import calculator.dto.Data;

public class Calculator {

    public static void run() {
        try {
            String inputData = InputDataReader.getInputData();
            Data data = DataParser.parseData(inputData);
            int result = sum(data);
            Logger.printResult(result);
        } finally {
            InputDataReader.close();
        }
    }

    private static int sum(Data data) {
        int sum = 0;
        String contents = data.getContents();
        String separators = data.getSeparators();
        String[] nums = contents.split(separators);
        try {
            for (int i = 0; i < nums.length; i++) {
                sum += Integer.parseInt(nums[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return sum;
    }
}
