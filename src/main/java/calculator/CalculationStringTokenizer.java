package calculator;

public class CalculationStringTokenizer {
    public String[] tokenize(String calculationString, Character customDelimiter) {
        //계산 문자열을 구분자로 분리
        String splitRegex = ":|,";

        if (customDelimiter != null) {
            splitRegex = splitRegex + "|" + customDelimiter;
        }

        return calculationString.split(splitRegex);
    }
}
