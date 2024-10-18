package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Console.readLine();
        InputManager inputManager = new InputManager(input);
        if (!inputManager.validate()) {
            throw new IllegalArgumentException("유효한 입력이 아닙니다.");
        }
        Separator separator = new Separator();

        if(inputManager.isCustomSeparatorCandidateExisted()) {
            separator.save(inputManager.getSeparatorCandidates());
        }

        OperandManager operandManager = new OperandManager();
        operandManager.save(inputManager.getOperandCandidates(), separator.getSeparators());

        Operator operator = new Operator();
        BigDecimal result = operator.add(operandManager.getOperands());

        System.out.println("결과 : " + result);
    }
}
