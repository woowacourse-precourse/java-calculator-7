package calculator.model;

public class CalculatorModel {

    // 기본 구분자와 커스텀 구분자 구분하기
    public boolean checkCustomDelimiter(String str) {
        return str.startsWith("//");
    }

    // 덧셈 기능
    public int sum(String delimiter, String numberFormula) {
        if (numberFormula.isEmpty()) {
            return 0;
        }

        String[] numberArray = numberFormula.split(delimiter);
        int result = 0;
        for (String number : numberArray) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    public String[] validateDelimiter(boolean delimiterType, String str) {
        return DelimiterValidationModel.validateDelimiter(delimiterType, str);
    }

}
