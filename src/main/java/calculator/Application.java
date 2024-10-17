package calculator;

import calculator.calculator.StringCalculator;
import calculator.config.AppConfig;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();  // AppConfig를 통해 의존성을 주입받음
        StringCalculator calculator = appConfig.stringCalculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();  // 사용자로부터 입력을 받음

        try {
            long result = calculator.add(input);
            System.out.println("결과 : " + result);
        } finally {
            Console.close();
        }
    }
}
