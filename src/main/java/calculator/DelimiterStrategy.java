package calculator;

public interface DelimiterStrategy {

    String[] splitNumbers(String input);

    // 입력 문자열이 해당 전략에 적합한지 판단하는 메서드
    boolean matches(String input);
}
