package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    private final StringCalculator calculator;

    // 의존성 주입을 통해 StringCalculator를 주입받음 (DIP 적용)
    public Application(StringCalculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            int result = calculator.start(input);  // 계산 실행
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());  // 예외 처리
        }
    }

    public static void main(String[] args) {
        // 구분자 전략 리스트 생성 (OCP 적용)
        List<DelimiterStrategy> strategies = List.of(
                new DefaultDelimiterStrategy(),
                new CustomDelimiterStrategy()
        );

        // 의존성 주입으로 StringCalculator 생성
        StringCalculator calculator = new StringCalculator(strategies);

        // Application 실행
        Application app = new Application(calculator);
        app.run();
    }
}
