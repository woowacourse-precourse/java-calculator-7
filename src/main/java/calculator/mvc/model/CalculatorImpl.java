package calculator.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl implements Calculator {
    private List<Long> numbers = new ArrayList<>();
    private static Calculator instance = new CalculatorImpl();

    private CalculatorImpl() {
    }

    public static Calculator getInstance() {
        return instance;
    }

    public static void reset() {
        instance = new CalculatorImpl();
    }

    @Override
    public void parseNumbersFromString(String input, String expression) throws IllegalStateException {
        if (input.isEmpty()) {
            return;
        }

        if (expression.length() >= 5 && expression.length() <= 6) {
            input = input.substring(5);
        }

        String[] tokens = input.split(expression);

        for (String s : tokens) {
            try {
                Long num = Long.valueOf(s);
                numbers.add(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("피연산자가 숫자가 아닙니다.");
            }
        }
    }

    @Override
    public long addNumbers() throws IllegalArgumentException {
        long tmp = 0;

        for (Long num : numbers) {
            if (num <= 0) {
                throw new IllegalArgumentException("양수가 아니므로 더하기 계산을 할 수 없습니다.");
            }

            if (tmp > Long.MAX_VALUE - num) {
                throw new IllegalArgumentException("결과값이 유효한 범위를 벗어났습니다.");
            }

            tmp += num;
        }

        return tmp;
    }
}
