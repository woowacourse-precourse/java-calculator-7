package calculator.runner;


import calculator.helper.IOHelper;
import calculator.helper.SeparateHelper;

import java.util.HashSet;
import java.util.Set;

import static calculator.helper.SeparateHelper.*;


public class CalculatorRunner {

    private String userInput;

    public void run() {

        userInput = IOHelper.getInput();

        if (userInput == null) {
            IOHelper.printResult(0);
            return;
        }

        Set<Character> temp = new HashSet<>(BASIC_SEPARATOR);
        if (isSeparator(userInput)) {
            String newSeparator = findSeparator(userInput);
            temp = addStringToCharSet(newSeparator);
        }
        String number = splitString(userInput);
        IOHelper.printResult(calculateSum(number,temp));
    }

    public int calculateSum(String inputString,Set<Character> newSeparator) {
        StringBuilder number = new StringBuilder();
        int num = 0;
        for (char ch : inputString.toCharArray()) {
            if (Character.isDigit(ch)) {
                number.append(ch);
                continue;
            } else if (newSeparator.contains(ch)) {
                if (number.isEmpty()) {
                    throw new IllegalArgumentException("구분자가 연속으로 들어왔습니다.");
                }
                num += Integer.parseInt(number.toString());
                number = new StringBuilder();
                continue;
            }
            throw new IllegalArgumentException("잘못된 구분자.");
        }

        if (!number.isEmpty()) {
            num += Integer.parseInt(String.valueOf(number));
        }

        return num;
    }
}
