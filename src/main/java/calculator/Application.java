package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String userInput = Console.readLine();
        StringCalculator sc = new StringCalculator(userInput);

        try {
            sc.calculate();
        } catch (Exception e) {
            System.err.println("예기치 못한 오류: " + e.getMessage());
        }
    }
}
