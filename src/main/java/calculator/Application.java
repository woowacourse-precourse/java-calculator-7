package calculator;

import calculator.model.Operand;
import calculator.service.CalculatorService;
import calculator.service.ExtractorService;
import calculator.service.impl.CalculatorServiceImpl;
import calculator.service.impl.ExtractorServiceImpl;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        ExtractorService extractor = new ExtractorServiceImpl();
        CalculatorService calculator = new CalculatorServiceImpl();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        Console.close();

        Operand operand = extractor.extract(input);

        System.out.println("결과 : " + calculator.calculate(operand));
    }
}
