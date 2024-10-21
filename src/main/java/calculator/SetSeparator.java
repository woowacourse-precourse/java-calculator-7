package calculator;

public class SetSeparator {
    // 구분자 설정 여부 확인
    public static String setSeparator(String input) {

        input = input.replace("\\n", "\n");

        if ((input.trim().startsWith("//")) && input.trim().contains("\n")) {
            Application.separator = input.trim().substring(2, input.indexOf("\n"));
        } else {
            Application.separator = Application.defaultSeparator;
            return input;
        }

        if (Application.separator == null || Application.separator.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자 지정이 안되었습니다.");
        }

        Application.separator = createSeparatorPattern();

        String result = input.trim().substring(input.indexOf("\n") + 1); // 구분자 설정을 제외한 부분만 남김
        return result;
    }
    // 구분자 설정
    public static String createSeparatorPattern() {
        StringBuilder regexPattern = new StringBuilder();

        for (int i = 0; i < Application.separator.length(); i++) {

            char c = Application.separator.charAt(i);

            if (regexPattern.indexOf(String.valueOf(c)) == -1) {

                if (!regexPattern.isEmpty()) {
                    regexPattern.append("|");
                }

                if ("[]{}()*+?.\\^$|".indexOf(c) != -1) {
                    regexPattern.append("\\").append(c);  // 특수 문자는 이스케이프처리
                } else {
                    regexPattern.append(c); // 구분자 목록에 새 구분자 추가
                }

            }
        }
        return regexPattern.toString();
    }
}