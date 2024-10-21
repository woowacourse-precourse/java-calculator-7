package calculator;

/**
 * 계산기의 전체적인 흐름을 관리하는 메인 클래스
 */
public class Application {
    private final InputHandler inputHandler;
    private final StringSplitter stringSplitter;
    private final Accumulator accumulator;
    private final OutputHandler outputHandler;

    /**
     * Application 생성자. 프로그램 실행에 필요한 각종 핸들러들을 주입받음
     *
     * @param inputHandler   입력을 처리하는 클래스
     * @param stringSplitter 문자열을 구분자로 분리하는 클래스
     * @param accumulator    계산을 수행하는 클래스
     * @param outputHandler  결과를 출력하는 클래스
     */
    public Application(InputHandler inputHandler, StringSplitter stringSplitter, Accumulator accumulator,
                       OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.stringSplitter = stringSplitter;
        this.accumulator = accumulator;
        this.outputHandler = outputHandler;
    }

    /**
     * Application 객체를 생성하고 run 메서드를 호출
     */
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();
        StringSplitter stringSplitter = new StringSplitter();
        Accumulator accumulator = new Accumulator();
        OutputHandler outputHandler = new OutputHandler();

        // Application 객체 생성 및 실행
        Application application = new Application(inputHandler, stringSplitter, accumulator, outputHandler);
        application.run();
    }

    /**
     * 프로그램의 주요 흐름을 실행하는 메서드. 입력을 받고, 문자열을 구분자로 분리한 후, 계산을 수행하고 결과를 출력
     */
    public void run() {
        // 입력 받기
        String input = inputHandler.getInput();

        // 입력된 문자열을 구분자로 분리하여 합계 계산
        int result = accumulator.sum(stringSplitter.split(input));

        // 결과 출력
        outputHandler.showOutput(result);
    }
}
