package calculator.operation;

import calculator.operation.constants.BasicDelimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAdditionCalculator {
    private final String DELIMITER_START = "//";
    private final String DELIMITER_END = "\\n";

    private List<String> delimiters;

    private String numberString;

    public StringAdditionCalculator(String numberString) {
        this.numberString = numberString;
    }

    public int calculateSum() {
        // 빈값 체크
        this.validateEmptyString();
        // 합계 반환
        return this.getSum();
    }

    /**
     * 합계 구하기
     */
    private int getSum() {
        // 최종 구분자
        String finalDelimiter = getFinalDelimiter();
        // 숫자 추출
        List<String> numbers = Arrays.stream(numberString.split(finalDelimiter)).toList();

        try {
            // 구분 결과 값 체크 (빈값, 음수)
            this.validateArrayValues(numbers);
            // 합계 반환
            return numbers.stream().mapToInt(Integer::parseInt).sum();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식", e);
        }
    }

    /**
     * 최종 구분자 생성
     */
    private String getFinalDelimiter() {
        // 기본 구분자 리스트
        List<String> basicDelimiters = Arrays.stream(BasicDelimiter.values())
            .map(BasicDelimiter::getDelimiter)
            .toList();

        // 커스텀 구분자 추가 가능한 리스트
        delimiters = new ArrayList<>(basicDelimiters);

        // 커스텀 구분자 추출 (recursive)
        this.extractCustomDelimiter();

        // 최종 구분자 반환
        return String.join("|", delimiters);
    }

    /**
     * 커스텀 구분자 추출
     */
    private void extractCustomDelimiter() {
        if (!numberString.startsWith(DELIMITER_START)) {
            // 커스텀 구분자 추출 후 문자열 형태 체크
            this.validateNumberString();
            return;
        }

        // 커스텀 구분자 indicator 가 제대로 닫혀 있는지 체크
        this.checkDelimiterEndIndicator();

        int startIdx = numberString.indexOf(DELIMITER_START);
        int endIdx = numberString.indexOf(DELIMITER_END);

        // 커스텀 구분자 추출
        String customDelimiter = numberString.substring(startIdx + DELIMITER_START.length(), endIdx);
        numberString = numberString.substring(endIdx + DELIMITER_END.length());

        // 구분자 리스트에 추가
        delimiters.add(customDelimiter);

        // 추출되지 않은 커스텀 구분자가 남아있으면 추출 (recursive)
        this.extractCustomDelimiter();
    }

    /**
     * 커스텀 구분자 indicator 가 제대로 닫혀 있는지 체크
     */
    private void checkDelimiterEndIndicator() {
        if (!numberString.contains(DELIMITER_END)) {
            throw new IllegalArgumentException("커스텀 구분자 지정 마크가 제대로 닫혀 있지 않음");
        }
    }

    /**
     * 빈값 체크
     */
    private void validateEmptyString() {
        if (numberString.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열");
        }
    }

    /**
     * 숫자로 시작하는 문자열인지 체크
     */
    private void validateNumberString() {
        // 빈값 체크
        this.validateEmptyString();
        // 문자열이 숫자로 시작하는지 않으면 exception
        if (!Character.isDigit(numberString.charAt(0))) {
            throw new IllegalArgumentException("계산 문자열이 숫자로 시작하지 않음");
        }
    }

    /**
     * 배열 내 빈값, 음수 체크
     *
     * @param numbers 추출된 숫자 배열
     */
    private void validateArrayValues(List<String> numbers) {
        this.checkIfEmptyValueExists(numbers);
        this.checkIfMinusValueExists(numbers);
    }

    /**
     * 배열 내 빈값 체크
     *
     * @param numbers 추출된 숫자 배열
     */
    private void checkIfEmptyValueExists(List<String> numbers) {
        // 빈값 체크
        if (numbers.isEmpty() || numbers.contains("") || numbers.contains(null)) {
            throw new IllegalArgumentException("구분자 사이에 빈 값 존재");
        }
    }

    /**
     * 배열 내 음수 체크
     *
     * @param numbers 추출된 숫자 배열
     */
    private void checkIfMinusValueExists(List<String> numbers) {
        boolean hasMinus = numbers.stream().anyMatch(num -> Integer.parseInt(num) < 0);
        if (hasMinus) {
            throw new IllegalArgumentException("음수 사용 불가");
        }
    }
}
