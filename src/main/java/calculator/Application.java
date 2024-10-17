package calculator;

import calculator.dto.Data;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        try {
            String inputData = InputDataReader.getInputData();
            boolean customStatus = isCustom(inputData);
            Data data = DataParser.parseData(inputData, customStatus);
            int sum = Calculator.sum(data);
            System.out.println("결과 : " + sum);
        } catch (IllegalArgumentException e) {
            throw e;
        } finally {
            Console.close();
        }
    }


    private static boolean isCustom(String inputData) {
        return inputData.startsWith("//");
    }
}
