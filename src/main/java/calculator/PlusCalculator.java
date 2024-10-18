package calculator;

import calculator.io.InputHandler;
import calculator.io.OutputHandler;

public class PlusCalculator {

    private final OutputHandler outputHandler = new OutputHandler();
    private final InputHandler inputHandler = new InputHandler();

    public void run() {
        try {
            outputHandler.showStartMessage();

            String userInput = inputHandler.getUserInput();
            String[] InputList = inputHandler.convertInputListBy(userInput);

            Integer result = addMachine(InputList);
            System.out.println("result = " + result);

        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public Integer addMachine(String[] inputList) {

        int result = 0;

        for (String s : inputList) {
            result += Integer.parseInt(s);
        }

        return result;
    }


}
