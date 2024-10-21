package calculator;

public class StringSplitter {

    private DelimiterManager delimiterManager;

    public StringSplitter(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
    }

    public String[] splitInput(String input) {
        // 구분자 배열을 정규 표현식으로 결합
        String regex = String.join("|", delimiterManager.getDelimiters());
        // 입력 문자열을 구분자로 분리
        return input.split(regex);
    }
}
