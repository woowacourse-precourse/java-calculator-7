package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        InputParser inputParser = new InputParser(input);

        Separator separator = new Separator();
        separator.save(inputParser.getSeparatorCandidates());

        OperandManager operandManager = new OperandManager();
        operandManager.save(inputParser.getOperandCandidates(), separator.getSeparators());

        Operator operator = new Operator();
        BigDecimal result = operator.add(operandManager.getOperands());

        System.out.println("결과 : " + result);
    }
}
