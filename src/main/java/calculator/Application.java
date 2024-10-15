package calculator;

import java.util.List;

import static calculator.NumberCalculator.calculateNumber;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String userInput = readLine();
        StringSpliter stringSpliter = new StringSpliter(userInput);
        List<String> splitUserInput;
        if (UserInputValidator.validateInputs(userInput)) {
            System.out.println("결과 : " + 0);
            return;
        }
        if (UserInputValidator.containCustomValidator(userInput)) {
            stringSpliter = new StringSpliter(userInput.substring(userInput.indexOf("\\") + 2), userInput.substring(2, userInput.indexOf("\\")));
            splitUserInput = stringSpliter.splitCustomDelUserInput();
        } else {
            splitUserInput = stringSpliter.splitUserInput();
        }
        if (UserInputValidator.isNumber(splitUserInput)) {
            System.out.println("결과 : " + calculateNumber(splitUserInput));
        }
        
    }
}
