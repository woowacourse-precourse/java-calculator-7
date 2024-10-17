package calculator.model;

public class DelimiterHandler {

    // final?? 써야한다는데 공부 필요 + static
    private String customStart ="//";
    private String customEnd ="\\n";

    // 왠지 String으로 관리해도 좋을듯
    private char delimiter1=',';
    private char delimiter2=':';

    // custom 구분자 문제 해결 필요
    // 디폴트구분자1과 2 랑 같은 값으로 지정해놓고 조건 만족하면 변경

    // 실제로 사용자가 의도한 값이 ','이면 문제가 발생함
    // 새로운 후보 : 0 (NULL 값)
    // 또는 flag를 만든다? 이게 나은듯
    private char customDelimiter = 0;
    private boolean customDelimiterFlag = false;

    private boolean checkDelimiter(String expression) {
        if (expression.indexOf(customStart) == 0 && expression.indexOf(customEnd) == 3){
            return true;
        }
        return false;
    }

    public char getDelimiter(String expression) {
            if (checkDelimiter(expression)) {
                customDelimiter = expression.charAt(2);
                customDelimiterFlag = true;
            }
        return customDelimiter;
    }

    public char[] getAllDelimiters() {
        if (customDelimiterFlag) {
            return new char[]{delimiter1, delimiter2, customDelimiter}; // 직접 반환
        } else {
            return new char[]{delimiter1, delimiter2}; // 직접 반환
        }
    }

    public boolean getCustomDelimiterFlag() {
        return customDelimiterFlag;
    }

}
