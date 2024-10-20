package calculator;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요!");
        String inputText = Console.readLine();
        try {
            TextCalculator calculator = new TextCalculator();
            calculator.validateText(inputText);
            int sum = calculator.calculateSum(inputText);

            System.out.println("결과: " + sum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}