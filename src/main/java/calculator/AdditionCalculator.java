package calculator;

import java.util.ArrayList;

import static calculator.UserView.*;

public class AdditionCalculator {
    private String userInput;
    private ArrayList<Integer> extractedNumber;

    public void run(){
        setUserInput();
        NumberExtraction numberExtraction = new NumberExtraction();
        extractedNumber = numberExtraction.run(userInput);
        printResult(getSumList());
    }

    public void setUserInput() {
        printStartCalculator();
        userInput = readInputString();
    }

    public int getSumList(){
        int total = 0;
        for (Integer n : extractedNumber) {
            total += n;
        }
        return total;
    }
}
