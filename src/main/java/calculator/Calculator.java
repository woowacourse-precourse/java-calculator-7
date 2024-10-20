package calculator;

public class Calculator {
    private final Adder adder;
    private final Delimiters delimiters;

    public Calculator(Adder adder, Delimiters delimiters) {
        this.adder = adder;
        this.delimiters = delimiters;
    }

    /**
     * 조건에 따라 입력된 문자열의 숫자를 계산하는 메서드입니다. 공백 처리, 숫자만 입력된 경우, 기본 구분자 및 커스텀 구분자를 처리하여 숫자를 합산합니다.
     *
     * @param input 사용자 입력 문자열
     * @return 계산된 합계 결과
     * @throws IllegalArgumentException 잘못된 형식의 입력이 주어진 경우 발생합니다.
     */
    public int calculate(String input) {

        input = input.trim();

        if (input == null || input.isBlank()) {
            return 0;
        }

        //숫자만 입력될 때
        if (input.matches("\\d+")) {
            return Integer.parseInt(input);
        }

        // 기본 구분자 처리
        if (input.contains(",") || input.contains(":")) {
            String[] numbers = delimiters.defaultDelimiter(input);
            return adder.sumNumbers(numbers);
        }

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            String[] numbers = delimiters.customDelimiter(input);
            return adder.sumNumbers(numbers);
        }
        throw new IllegalArgumentException();
    }
}