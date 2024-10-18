package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 콘솔에서 입력을 받아 처리
        String input = Console.readLine();

        // InputParser와 Calculator를 생성
        InputParser parser = new InputParser();
        Calculator calculator = new Calculator(parser);

        // 계산을 수행하고 결과 출력
        int sum = calculator.calculate(input);
        System.out.println("결과 : " + sum);
    }
}
