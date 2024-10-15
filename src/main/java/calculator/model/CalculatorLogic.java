package calculator.model;

public class CalculatorLogic {

    public String extractDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            return input.substring(2, delimiterEndIndex);
        }
        return ",|:"; //정규식 문법으로 , 또는 :를 구분자로 인식함(|는 or)
    }
}
