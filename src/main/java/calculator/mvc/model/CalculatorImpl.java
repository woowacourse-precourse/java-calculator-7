package calculator.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl implements Calculator {
    private List<Character> separators = new ArrayList<>();
    private List<String> customSeparators = List.of("//", "\n");
    private List<Long> numbers = new ArrayList<>();
    private static Calculator instance = new CalculatorImpl();

    private CalculatorImpl() {
        separators.add(',');
        separators.add(':');
    }

    public static Calculator getInstance() {
        return instance;
    }

    public void findCustomSeparator(String input) throws IllegalStateException {
        int idx = 2;

        if (existCustomSeparator(input)) {
            if ('0' <= input.charAt(idx) && input.charAt(idx) <= '9') {
                throw new IllegalArgumentException("커스텀 구분자로 숫자를 입력할 수 없습니다.");
            }

            separators.add(input.charAt(idx));
        }
    }

    private boolean existCustomSeparator(String input) throws IllegalStateException {
        if (input.startsWith(customSeparators.get(0))) {
            if (input.indexOf(customSeparators.get(1)) == -1) {
                throw new IllegalArgumentException("\"\n\"가 문자열에 존재하지 않습니다.");
            }

            if (input.indexOf(customSeparators.get(1)) > 3) {
                throw new IllegalArgumentException("길이 1인 커스텀 구분자를 입력하지 않았습니다.");
            }

            if (input.indexOf(customSeparators.get(1)) == 3) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void parseNumbersFromString(String input) {

    }

    @Override
    public long addNumbers() throws IllegalArgumentException {
        long tmp = 0;

        for (Long num : numbers) {
            if (num <= 0) {
                throw new IllegalArgumentException("양수가 아니므로 더하기 계산을 할 수 없습니다.");
            }
            tmp += num;
        }

        return tmp;
    }
}
