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

        if (userInput == null || userInput.trim().isEmpty()) {
            IOHelper.printResult(0);
            return;
        }

        Set<Character> temp = new HashSet<>(BASIC_SEPARATOR);
        if (isSeparator(userInput)) {
            String newSeparator = findSeparator(userInput);
            temp = addStringToCharSet(newSeparator);
        }
        String number = splitString(userInput);
        if (temp.contains(number.charAt(0))) {
            throw new IllegalArgumentException("입력은 구분자로 시작할 수 없습니다.");
        }
        IOHelper.printResult(calculateSum(number,temp));
    }

    public int calculateSum(String inputString,Set<Character> newSeparator) {
        StringBuilder number = new StringBuilder();
        int sum = 0;
        boolean lastCharWasSeparator = false;

        for (char ch : inputString.toCharArray()) {
            if (Character.isDigit(ch)) {
                number.append(ch);
                lastCharWasSeparator = false;
            } else if (newSeparator.contains(ch)) {
                if (lastCharWasSeparator) {
                    throw new IllegalArgumentException("구분자가 연속으로 들어왔습니다.");
                }

                if (number.length() > 0) {
                    sum += Integer.parseInt(number.toString());
                    number.setLength(0);
                }
                lastCharWasSeparator = true;
            } else {
                // 잘못된 구분자가 있는 경우 예외 발생
                throw new IllegalArgumentException("잘못된 구분자입니다.");
            }
        }

        if (number.length() > 0) {
            sum += Integer.parseInt(number.toString());
        }

        return sum;
    }
}
