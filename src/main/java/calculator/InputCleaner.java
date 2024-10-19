package calculator;

public class InputCleaner {
    // 입력에서 줄바꿈 문자 처리 메서드
    public String sanitize(String input) {
        return input.replace("\\n", "\n");  // \n 처리
    }
}
