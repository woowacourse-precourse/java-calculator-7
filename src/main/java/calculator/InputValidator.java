package calculator;

public class InputValidator {

    private DelimiterManager delimiterManager;

    public InputValidator(DelimiterManager delimiterManager) {
        this.delimiterManager = delimiterManager;
    }

    public void validateInput(String input) {
        // 구분자로 문자열 분리
        String[] splitedString = new StringSplitter(delimiterManager).splitInput(input);

        // 분리된 문자 배열에서 구분자 이외의 문자, 음수가 있는지 확인
        for (String str : splitedString) {
            try {
                int num = Integer.parseInt(str); // 숫자가 아닌 경우 예외 발생
                // 음수 처리
                if (num < 0) {
                    throw new IllegalArgumentException("음수가 존재합니다.");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자 이외의 문자가 존재합니다:");
            }
        }
    }
}
