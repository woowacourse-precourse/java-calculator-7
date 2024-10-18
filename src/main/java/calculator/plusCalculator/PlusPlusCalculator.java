package calculator.plusCalculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlusPlusCalculator implements PlusCalculatorInterface {

    public PlusPlusCalculator(List<String> separators) {
        this.separators = new ArrayList<>(separators);
    }

    // 구분자 리스트
    List<String> separators;

    public int run(String input) {
        input = findCustomSeparator(input);
        sortSeparatorsSizeDesc();
        List<Integer> integerNumbers = extractNumbers(input);
        return calculate(integerNumbers);
    }


    public String findCustomSeparator(String input) {
        while (hasCustomSeparator(input)) {
            input = extractCustomSeparator(input);
        }

        return input;
    }


    public boolean hasCustomSeparator(String input) {

        if (!input.contains("//")) {
            return false;
        }

        // //가 맨 앞에 있지만 \\n이 없는 경우 or //위치가 문자열의 처음이 아닌경우
        if ((input.indexOf("//") == 0 && !input.contains("\\n")) || input.indexOf("//") > 0) {
            throw new IllegalArgumentException();
        }

        return true;
    }


    public String extractCustomSeparator(String input) {
        int customSeparatorEnd = input.indexOf("\\n");
        String customSeparator = input.substring(2, customSeparatorEnd);
        separators.add(customSeparator);
        return input.substring(customSeparatorEnd + 2);
    }


    public List<Integer> extractNumbers(String input) {
        List<Integer> integerNumbers = new ArrayList<>();

        // numberString이 공백이면 0으로 간주
        if (input.isBlank()) {
            integerNumbers.add(0);
            return integerNumbers;
        }

        // split으로 구분자 기준으로 숫자만 추출
        String[] stringNumbers = input.split(getSeparatorsSplitRegex());

        // extractNumber를 이용해 Integer로 변환하여 result에 저장
        for (String stringNumber : stringNumbers) {
            integerNumbers.add(extractNumber(stringNumber));
        }

        return integerNumbers;
    }


    public void sortSeparatorsSizeDesc() {
        separators.sort(Comparator.comparingInt(String::length).reversed());
    }


    public String getSeparatorsSplitRegex() {
        return String.join("|", separators);
    }


    public Integer extractNumber(String numberString) {
        int numberInteger;

        try {
            numberInteger = Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (numberInteger < 0) {
            throw new IllegalArgumentException();
        }

        return numberInteger;
    }


    public Integer calculate(List<Integer> integerNumbers) {
        int result = 0;
        for (int integerNumber : integerNumbers) {
            result = result + integerNumber;
        }
        return result;
    }

}
