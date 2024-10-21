package calculator;

public class InputValidator {
    public void validateCustomDelimiter(String customDelimiter) {
        // 예외 : 커스텀 구분자 = "-" 일 경우
        if (customDelimiter.equals("-")) {
            throw new IllegalArgumentException("커스텀 구분자로 -를 사용할 수 없습니다.");
        }
        // 예외 : 커스텀 구분자가 숫자일 경우
        if (customDelimiter.matches("[0-9]")) {
            throw new IllegalArgumentException("커스텀 구분자로 숫자를 사용할 수 없습니다.");
        }
    }

    public void validateFormula(String formula, String delimiter) {
        String formulaRegex = "^\\d+([" + delimiter + "]\\d+)*$";
        // 예외 : 덧셈식 형식이 잘못된 경우
        if (!formula.matches(formulaRegex)) {
            throw new IllegalArgumentException("덧셈식 형식이 잘못되었습니다.");
        }
    }
}
