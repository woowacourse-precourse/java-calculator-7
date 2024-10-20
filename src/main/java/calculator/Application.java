package calculator;

import calculator.calculator.Calculator;
import calculator.input.Input;
import calculator.parser.Parser;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        List<String> basicSeparators = List.of(",", ":");
        String separatorStart = "//";
        String separatorEnd = "\\n";

        // TODO: 입력받기
        // 한줄 vs 두줄 입력 구분 필요
        Input input = new Input(separatorStart, separatorEnd);
        List<String> inputs = input.read(Console::readLine);

        System.out.println(inputs);

        // TODO: policy 정하기
        Predicate<Integer> positivePolicy = (num) -> num >= 0;
        List<Predicate<Integer>> policies = List.of(positivePolicy);

        // TODO: Parsing 하기
        Parser parser = new Parser(basicSeparators);

        // 구분자 추가
        if(inputs.size() > 1) parser.updateInput(inputs.getFirst()).addSeparators();
        // 피연산자 구하기
        List<Integer> operands = parser.updateInput(inputs.getLast()).parse(policies);

        // TODO: 계산하기
        Calculator calculator = new Calculator(Integer::sum);
        Integer result = calculator.calculate(operands, 0);

        // TODO: 출력하기
        System.out.println("결과 : " + result);
    }
}
