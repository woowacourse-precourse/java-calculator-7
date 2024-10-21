package calculator;

public class Application {
    private final InputHandler inputHandler;
    private final StringSplitter stringSplitter;
    private final Accumulator accumulator;
    private final OutputHandler outputHandler;

    public Application(InputHandler inputHandler, StringSplitter stringSplitter, Accumulator accumulator,
                       OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.stringSplitter = stringSplitter;
        this.accumulator = accumulator;
        this.outputHandler = outputHandler;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        StringSplitter stringSplitter = new StringSplitter();
        Accumulator accumulator = new Accumulator();
        OutputHandler outputHandler = new OutputHandler();

        Application application = new Application(inputHandler, stringSplitter, accumulator, outputHandler);

        application.run();
    }

    public void run() {
        String input = inputHandler.getInput();
        int result = accumulator.sum(stringSplitter.split(input));
        outputHandler.showOutput(result);
    }
}
