package calculator;

public class StringController {
    private final InputView inputView;
    private final OutputView outputView;
    private final StringFacadeService stringFacadeService;


    public StringController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.stringFacadeService = new StringFacadeService();
    }

    public void start() {
        String input = inputView.getUserInput();
        if (input.isEmpty()) {
            System.out.println("결과 : 0");
        } else {
            int answer = stringFacadeService.addNumbersFromInput(input);
            outputView.displayResult(answer);
        }
    }
}
