package calculator;

public class StringCalculator {
    private final SeparatorManager sepManager;
    private final StringSplitter stringSplitter;
    private final StringConverter stringConverter;
    private final InputHandler inputHandler;
    private final SumCalculator sumCalculator;
    private final NumberValidator numberValidator;

    public StringCalculator() {
        this.sepManager = new SeparatorManager();
        this.stringSplitter = new StringSplitter(this.sepManager);
        this.numberValidator = new NumberValidator();
        this.stringConverter = new StringConverter(this.numberValidator);
        this.sumCalculator = new SumCalculator(this.stringSplitter, this.stringConverter, this.sepManager);
        this.inputHandler = new InputHandler();
    }

    public void run(){
        String input = inputHandler.getInput();
        int result = sumCalculator.sum(input);
        System.out.println("결과 : " + result);
    }

    // 테스트를 위한 메서드, 입력을 직접 받음
    public int runWithInput(String input) {
        return sumCalculator.sum(input);
    }
}
