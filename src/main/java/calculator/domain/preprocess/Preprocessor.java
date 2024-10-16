package calculator.domain.preprocess;

public class Preprocessor {

    private final DelimeterProcessor delimeterProcessor;
    private final InputManager inputManager;
    private final SplitManager splitManager;

    public Preprocessor(DelimeterProcessor delimeterProcessor, InputManager inputManager, SplitManager splitManager) {
        this.delimeterProcessor = delimeterProcessor;
        this.inputManager = inputManager;
        this.splitManager = splitManager;
    }


}
