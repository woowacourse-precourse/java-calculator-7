package calculator;

import java.math.BigInteger;

public class ApplicationContext {
    private final UserInteractionManager userInteractionManager;
    private final InputManager inputManager;
    private final SeparatorManager separatorManager;
    private final OperandManager operandManager;
    private final Operator operator;

    public ApplicationContext() {
        this.userInteractionManager = new UserInteractionManager();
        this.inputManager = new InputManager();
        this.separatorManager = new SeparatorManager();
        this.operandManager = new OperandManager(separatorManager);
        this.operator = new Operator();
    }

    public void run() {
        String input = userInteractionManager.readInput();
        inputManager.save(input);
        if(inputManager.isCustomSeparatorCandidateExisted()) {
            separatorManager.save(inputManager.getSeparatorCandidate());
        }
        operandManager.save(inputManager.getOperandCandidates());
        BigInteger result = operator.add(operandManager.getOperands());
        userInteractionManager.printOutput(result);
    }
}
