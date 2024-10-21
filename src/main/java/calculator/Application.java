package calculator;

import calculator.model.InputData;

public class Application {
    public static void main(String[] args) {

        InputData input = InputService.readLine();

        int result = OperationService.sumStringNum(input.stringNum, input.delimiter);

        System.out.println("결과 : " + result);
    }
}
