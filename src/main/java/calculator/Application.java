package calculator;

public class Application {
    // 의존성 주입
    private final InputHandler inputhandler;
    private final ArraySumCalculator arraysumcalculator;

    // 의존성 주입 후 객체 생성
    public Application(InputHandler inputhandler, ArraySumCalculator arraysumcalculator) {
        this.inputhandler = inputhandler;
        this.arraysumcalculator = arraysumcalculator;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // StringValidatorImpl 객체를 생성하여 StringSplitter에 주입
        StringValidator validator = new StringValidatorImpl();
        StringSplitter splitter = new StringSplitter(validator);  // 의존성 주입

        // ArraySumCalculator에 StringSplitter 의존성 주입
        ArraySumCalculator arraysumcalculator = new ArraySumCalculator(splitter);

        // Application에 InputHandler와 ArraySumCalculator 주입
        Application application = new Application(new InputHandler(), arraysumcalculator);

        application.run();
    }

    public void run() {
        String input = inputhandler.userInput();
        int result = arraysumcalculator.sumArrayElements(input);
        System.out.println("결과 : " + result);
    }
}