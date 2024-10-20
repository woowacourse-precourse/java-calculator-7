package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {
    public static void main(String[] args) throws RuntimeException {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputText;
        try {
            inputText = Console.readLine();
        } catch (NoSuchElementException e) {
            inputText = "";
        }
        InputParser inputParser = new InputParser(inputText);
        Calculator calculator = new Calculator(inputParser);
        Number totalSum = calculator.calculateTotalSum();
        System.out.printf("결과 : %s\n", totalSum);
    }
}
