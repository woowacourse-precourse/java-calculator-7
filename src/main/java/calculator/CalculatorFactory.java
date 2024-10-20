package calculator;


/**
 * 계산기 객체를 생성하는 팩토리 클래스입니다.
 * 이 클래스는 입력 문자열의 형식에 따라 적절한 계산기 객체를 생성합니다.
 */
public class CalculatorFactory {

    //생성자를 private으로 선언하여 인스턴스화를 방지
    private CalculatorFactory() {}

    /**
     * 주어진 입력 문자열에 따라 적절한 계산기 객체를 생성합니다.
     *
     * @param input 계산할 문자열 입력값
     * @return 생성된 Calculator 객체
     * @throws IllegalArgumentException 입력값이 null이거나 비어있는 경우
     */
    public static Calculator createCalculator(String input) {

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값이 비어 있습니다.");
        }

        if (input.startsWith("//") && input.contains("\\n")) {
            return new CustomDelimiterCalculator(input);
        } else {
            return new DefaultCalculator(input);
        }
    }
}
