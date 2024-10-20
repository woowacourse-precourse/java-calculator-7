package calculator;

public class NumberSplitter {
    public String[] splitNumbers(String input, String delimiters){ // 구분자 + 커스텀 구분자를 기준으로 숫자로된 문자열 배열 반환.
        return input.split("[" + delimiters + "]");
    }
}
