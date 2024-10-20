package calculator;

public class ApplicationRunner {
    private final UserInteractionManager userInteractionManager;
    private final InputManager inputManager;
    private final SeparatorManager separatorManager;
    private final OperandManager operandManager;
    private final Operator operator;

    public ApplicationRunner(ApplicationContext context) {
        this.userInteractionManager = context.getUserInteractionManager();
        this.inputManager = context.getInputManager();
        this.separatorManager = context.getSeparatorManager();
        this.operandManager = context.getOperandManager();
        this.operator = context.getOperator();
    }

    public void run() {
        String input = userInteractionManager.readInput();
        inputManager.save(input);

        if (inputManager.isCustomSeparatorCandidateExisted()) {
            separatorManager.save(inputManager.getSeparatorCandidate());
        }
        operandManager.save(inputManager.getOperandCandidates());
        int result = operator.add(operandManager.getOperands());
        userInteractionManager.printOutput(result + "");
    }
}
