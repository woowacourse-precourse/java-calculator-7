package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();

        InputManager inputManager = new InputManager(input);
        inputManager.validate();

        SeparatorManager separatorManager = new SeparatorManager();

        if(inputManager.isCustomSeparatorCandidateExisted()) {
            separatorManager.validate(inputManager.getSeparatorCandidates());
            separatorManager.save(inputManager.getSeparatorCandidates());
        }

        OperandManager operandManager = new OperandManager();
        operandManager.save(inputManager.getOperandCandidates(), separatorManager.getSeparators());

        Operator operator = new Operator();
        BigDecimal result = operator.add(operandManager.getOperands());

        System.out.println("결과 : " + result);
    }
}
