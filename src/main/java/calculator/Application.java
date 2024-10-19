package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();

        InputManager inputManager = new InputManager(input);
        inputManager.validate();

        SeparatorManager separatorManager = new SeparatorManager();

        if(inputManager.isCustomSeparatorCandidateExisted()) {
            separatorManager.validate(inputManager.getSeparatorCandidate());
            separatorManager.save(inputManager.getSeparatorCandidate());
        }

        OperandManager operandManager = new OperandManager();
        operandManager.save(inputManager.getOperandCandidates(), separatorManager.getSeparators());

        Operator operator = new Operator();
        BigInteger result = operator.add(operandManager.getOperands());

        System.out.print("결과 : " + result);
    }
}
