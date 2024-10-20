package calculator.io;

import calculator.basic.BasicHandler;
import calculator.custom.CustomHandler;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {

    public String getUserInput() {
        return readLine();
    }

    public String[] convertInputListBy(String userInput) {

        if (userInput == null || userInput.isEmpty()) {
            return new String[]{"0"};
        }

        CustomHandler customHandler = CustomHandler.of(this);
        if (customHandler.checkInputIsCustom(userInput)) {
            return customHandler.convertValidInputListCustom(userInput);
        } else {
            BasicHandler basicHandler = BasicHandler.of(this);
            return basicHandler.convertValidInputList(userInput);
        }

    }

    public void lastIndexIsInteger(String userInput) {
        try {
            String lastIndex = String.valueOf(userInput.charAt(userInput.length() - 1));
            Integer.parseInt(lastIndex);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void isPositiveInteger(String s) {
        try {
            int number = Integer.parseInt(s);

            if (number < 1) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
