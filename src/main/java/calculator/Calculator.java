package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private String userInput;
    private Integer calculateResult;

    public Calculator() {
    }


    public String setUserInputByCustomConsole() {
        try {
            this.userInput = Console.readLine();
            return this.userInput;
        } catch (OutOfMemoryError e) {
            throw new IllegalArgumentException("[ERROR] Out of memory : ", e);
        }
    }

    public void resultShowConsole() {
        System.out.println("결과 : " + this.calculateResult);
    }

    public String resultShowConsole(String givenInput) {
        if(givenInput == null || givenInput.isEmpty()) {
            System.out.println(this.calculateResult);
            return "결과 : " +this.calculateResult;
        }
        String outMessage =  "결과 : " + givenInput;
        System.out.println(outMessage);
        return outMessage;
    }
}