package calculator;

public class Application {
    private final InputHandler inputHandler;

    public Application(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();

        Application application = new Application(inputHandler);

        application.run();
    }

    public void run() {
        inputHandler.getInput();
    }
}
