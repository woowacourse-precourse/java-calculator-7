package calculator;

public class Application {
    // 의존성 주입
    private final InputHandler inputHandler;
    private final ArraySumCalculator arraySumCalculator;

    // 의존성 주입 후 객체 생성
    public Application(InputHandler inputHandler, ArraySumCalculator arraySumCalculator) {
        this.inputHandler = inputHandler;
        this.arraySumCalculator = arraySumCalculator;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // StringValidatorImpl 객체를 생성하여 StringSplitter에 주입
        StringValidator validator = new StringValidatorImpl();
        StringSplitter splitter = new StringSplitter(validator);  // 의존성 주입

        // ArraySumCalculator에 StringSplitter 의존성 주입
        ArraySumCalculator sumCalculator = new ArraySumCalculator(splitter);

        // Application에 InputHandler와 ArraySumCalculator 주입
        Application application = new Application(new InputHandler(), sumCalculator);

        // 실행
        application.run();
    }

    public void run() {
        // 사용자 입력 받아서 처리
        String input = inputHandler.UserInput();
        int result = arraySumCalculator.sumArrayElements(input);  // 배열 요소 합 계산
        System.out.println("입력된 숫자의 합은: " + result);
    }
}