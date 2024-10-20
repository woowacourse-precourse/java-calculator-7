package calculator;

public class AdditionCalculator {
    private final UserView userView = new UserView();
    private int result = 0;
    private String userInput;

    public void run(){
        userView.printStartCalculator();
        setUserInput();
        userView.printResult(result);
    }

    public void setUserInput() {
        userInput = userView.readInputString();
    }
}
