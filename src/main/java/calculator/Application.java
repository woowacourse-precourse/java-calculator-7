package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("입력하세요");
        String input = readLine();

        DefaultCal calculator = new DefaultCal();
        int result = calculator.cal(input);

        System.out.println("결과 : " + result);
    }
}
