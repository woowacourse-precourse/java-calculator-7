package calculator;

import calculator.input_processor.OperandConverter;
import calculator.input_processor.SimpleCalculator;
import calculator.input_processor.OperandExtractor;
import calculator.input_processor.OperandProcessor;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        OperandExtractor operandExtractor = new OperandExtractor();
        OperandConverter operandConverter = new OperandConverter();
        OperandProcessor operandProcessor = new OperandProcessor();
        SimpleCalculator simpleCalculator = new SimpleCalculator(operandExtractor, operandConverter, operandProcessor);

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        int result = simpleCalculator.run(Console.readLine());
        System.out.printf("결과 : %d:", result);
    }
}
