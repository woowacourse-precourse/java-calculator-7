package calculator.model;

public class CalculatorModel {

    // 덧셈 구하는 함수
    public int sum(String delimiter, String numberFormula) {
        if (numberFormula.isEmpty()) {
            return 0;
        }
        int result = 0;
        String[] numberArray = numberFormula.split(delimiter);
        for (String number : numberArray) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    // 기본 구분자 or 커스텀 구분자 구별하는 함수
    public boolean getDelimiterType(String formula) {
        return formula.startsWith("//");
    }

    public String[] validateDelimiter(boolean delimiterType, String formula) {
        return DelimiterValidationModel.validateDelimiter(delimiterType, formula);
    }
}
