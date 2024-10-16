package calculator;

public class DelimiterParser {

    public String[] splitNumbers(String input) {
        String delimiter = ",|:"; // 기본 구분자. 정규표현식 사용
        String numbersPart = input; // 숫자 부분

        return numbersPart.split(delimiter);
    }
}
