package calculator;

public class Application {
    private final InputHandler inputHandler;
    private final StringSplitter stringSplitter;
    private final Accumulator accumulator;

    public Application(InputHandler inputHandler, StringSplitter stringSplitter, Accumulator accumulator) {
        this.inputHandler = inputHandler;
        this.stringSplitter = stringSplitter;
        this.accumulator = accumulator;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        StringSplitter stringSplitter = new StringSplitter();
        Accumulator accumulator = new Accumulator();

        Application application = new Application(inputHandler, stringSplitter, accumulator);

        application.run();
    }

    public void run() {
        String input = inputHandler.getInput();
        int result = accumulator.sum(stringSplitter.split(input));
        System.out.println("결과 : " + result);
    }
}
