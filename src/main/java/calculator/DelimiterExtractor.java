package calculator;

public class DelimiterExtractor {
    //커스텀 구분자를 알아내는 클래스
    //커스텀 구분자란? 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 구분자로 사용하는것
    //커스텀 구분자가 없다면 => 쉼표와 콜론으로만 구분

    String customDelimiter = null;

    public DelimiterExtractor(String str) {
        extractDelimiter(str);
    }
    void extractDelimiter(String str) {
        // 문자열이 "//"로 시작하는지?
        if (str.startsWith("//")) {
            int newlineIndex = str.indexOf("\n");
            if (newlineIndex != -1) {
                // "//"와 "\n" 사이의 문자를 커스텀 구분자로 설정
                customDelimiter = str.substring(2, newlineIndex);
            }
        } else {
            // 커스텀 구분자가 설정되지 않은 경우 : 기본 구분자(쉼표, 콜론) 사용
            customDelimiter = null; 
        }
    }
    public String getCustomDelimiter() {
        return customDelimiter;
    }
}
