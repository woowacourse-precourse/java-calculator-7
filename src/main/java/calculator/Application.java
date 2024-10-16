package calculator;

import calculator.dto.Data;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        try {
            String inputData = getInputData();
            boolean customStatus = isCustom(inputData);
            Data data = DataParser.parseData(inputData, customStatus);
            int sum = Calculator.sum(data);
            System.out.println("결과 : " + sum);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("프로그램 종료");
        } finally {
            Console.close();
        }
    }

    private static String getInputData() {
        String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }

    private static boolean isCustom(String inputData) {
        return inputData.startsWith("//");
    }
}
