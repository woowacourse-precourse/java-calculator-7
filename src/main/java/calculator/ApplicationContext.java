package calculator;

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

    public UserInteractionManager getUserInteractionManager() {
        return userInteractionManager;
    }

    public InputManager getInputManager() {
        return inputManager;
    }

    public SeparatorManager getSeparatorManager() {
        return separatorManager;
    }

    public OperandManager getOperandManager() {
        return operandManager;
    }

    public Operator getOperator() {
        return operator;
    }
}
