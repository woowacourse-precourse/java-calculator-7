package calculator;

import calculator.util.StringSplitter;
import calculator.util.StringValidator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private final ArrayCalculator arraycalculator;
    private static final StringValidator validator = new StringValidator();
    private static final StringSplitter splitter = new StringSplitter(validator);

    public Application(ArraySumCalculator arraysumcalculator) {
        this.arraycalculator = arraysumcalculator;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application(new ArraySumCalculator(splitter));
        application.run(application);
    }

    public void run(Application application) {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        int result = arraycalculator.sumArrayElements(input);
        System.out.println("결과 : " + result);
    }
}