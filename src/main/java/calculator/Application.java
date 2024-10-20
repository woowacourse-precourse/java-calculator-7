package calculator;

import java.math.BigInteger;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserInteractionManager userInteractionManager = new UserInteractionManager();
        InputManager inputManager = new InputManager(input);
        SeparatorManager separatorManager = new SeparatorManager();
        OperandManager operandManager = new OperandManager(separatorManager);
        Operator operator = new Operator();

        if(inputManager.isCustomSeparatorCandidateExisted()) {
            separatorManager.save(inputManager.getSeparatorCandidate());
        }
        operandManager.save(inputManager.getOperandCandidates());
        BigInteger result = operator.add(operandManager.getOperands());
        userInteractionManager.printOutput(result);
    }
}
