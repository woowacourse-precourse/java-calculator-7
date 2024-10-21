package calculator;

import calculator.number.DoubleSum;
import calculator.number.IntSum;
import calculator.number.NumberSum;
import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class Calculator {

    private final Delimiters delimiters = new Delimiters();
    private final Converter converter = new Converter();

    public void startCalculate() {
        System.out.println("덧셈할 문자열을 입력해주세요.");

        String inputString;

        try {
            inputString = Console.readLine();
        } catch (NoSuchElementException e) {
            System.out.println("결과 : 0");
            return;
        }

        String[] numList = delimiters.getNumList(inputString);

        NumberSum sum = determineNumberSumType(numList);

        for (String token : numList) {
            String trimToken = token.trim();
            sum.add(converter.convertToValidNumber(trimToken));
        }

        if (sum.isWholeNumber()) {
            System.out.println("결과 : " + (int) sum.getValue());
        } else {
            System.out.println("결과 : " + sum.getValue());
        }
    }

    private NumberSum determineNumberSumType(String[] numList) {
        for (String token : numList) {
            String trimToken = token.trim();
            if (trimToken.contains(".")) {
                return new DoubleSum();
            }
        }
        return new IntSum();
    }
}