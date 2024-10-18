package calculator;

import calculator.dto.Data;
import calculator.parser.ParseManager;

public class Calculator {

    public static final String ELEMENT_NOT_INTEGER_ERR_MESSAGE = "정수가 아니거나 정수형 범위를 벗어납니다.";
    public static final String RESULT_OVERFLOW_ERR_MESSAGE = "합이 정수형 범위를 벗어납니다.";

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
                longSum += Long.parseLong(nums[i]);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ELEMENT_NOT_INTEGER_ERR_MESSAGE);
        }

        if (sum != longSum) {
            throw new IllegalArgumentException(RESULT_OVERFLOW_ERR_MESSAGE);
        }

        return sum;
    }
}
