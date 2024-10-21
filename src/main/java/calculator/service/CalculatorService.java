package calculator.service;

import calculator.util.Constants;
import calculator.util.Delimiters;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class CalculatorService {
    public void calculate() {

        System.out.println(Constants.INPUT_MESSAGE.getMessage());

        String value = readLine();
        List<Integer> valuesToCalculate = new ArrayList<>();

        try {
            if (value.isEmpty()) {
                valuesToCalculate.add(0);
            } else {
                if (value.contains(Delimiters.NEGATIVE.getSymbol())) {
                    throw new IllegalArgumentException(Constants.ERROR_NEGATIVE_NUMBER.getMessage());
                }
                if (value.contains(Delimiters.COLON.getSymbol()) || value.contains(Delimiters.COMMA.getSymbol())) {
                    String[] tokens = value.split(Delimiters.getRegex());
                    for (String token : tokens) {
                        int num = Integer.parseInt(token.trim());
                        valuesToCalculate.add(num);
                    }
                } else {
                    for (char c : value.toCharArray()) {
                        if (Character.isDigit(c)) {
                            valuesToCalculate.add(Character.getNumericValue(c));
                        }
                    }
                }
                int sum = valuesToCalculate.stream().mapToInt(Integer::intValue).sum();
                System.out.println(Constants.OUTPUT_MESSAGE.getMessage() + sum);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("오류 발생: " + e.getMessage());
            throw e;
        }

    }
}
