package calculator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Calculator {

    public Calculator(List<String> separators) {
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

    /**
     * 커스텀 구분자를 찾는 메서드
     *
     * @return 커스텀 구분자를 제외한 String
     */
    public String findCustomSeparator(String input) {
        while (hasCustomSeparator(input)) {
            input = extractCustomSeparator(input);
        }

        return input;
    }

    /**
     * 커스텀 구분자가 있는지 검사하는 메서드
     *
     * @return boolean
     */
    private boolean hasCustomSeparator(String input) {

        if (!input.contains("//")) {
            return false;
        }

        // //가 맨 앞에 있지만 \\n이 없는 경우 or //위치가 문자열의 처음이 아닌경우
        if ((input.indexOf("//") == 0 && !input.contains("\\n")) || input.indexOf("//") > 0) {
            throw new IllegalArgumentException();
        }

        return true;
    }

    /**
     * 맨 앞 커스텀 구분자를 추출하여 빼 separators에 저장하고, 커스텀 구분자를 뺸 문자열을 반환하는 메서드
     *
     * @return 맨 앞의 커스텀 구분자를 뺀 문자열
     */
    private String extractCustomSeparator(String input) {
        int customSeparatorEnd = input.indexOf("\\n");
        String customSeparator = input.substring(2, customSeparatorEnd);
        separators.add(customSeparator);
        return input.substring(customSeparatorEnd + 2);
    }

    /**
     * 구분자로 split하여 숫자 추출
     *
     * @return 문자열에서 숫자를 모은 List<Integer>
     */
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

    /**
     * ,, 같은 중복 구분자를 처리하기 위한 separators 정렬 메서드
     *
     * @return void
     */
    public void sortSeparatorsSizeDesc() {
        separators.sort(Comparator.comparingInt(String::length).reversed());
    }

    /**
     * split에 사용할 구분자 문자열을 만드는 메서드
     *
     * @return 구분자 문자열 String
     */
    public String getSeparatorsSplitRegex() {
        return String.join("|", separators);
    }

    /**
     * String을 Integer로 변환해 반환 parseInt로 변환 실패하거나, 음수가 나오면 예외 처리
     *
     * @return Integer
     */
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

    /**
     * 숫자합 계산
     *
     * @return int 합
     */
    public Integer calculate(List<Integer> integerNumbers) {
        int result = 0;
        for (int integerNumber : integerNumbers) {
            result = result + integerNumber;
        }
        return result;
    }

}
