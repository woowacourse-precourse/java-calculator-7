package calculator;

public class DelimiterProcessor {

    public static String extractDelimiter(String input) {
        if (input.startsWith("//")) {
            // 구분자 포맷 확인
            if (!input.contains("\n")) {
                throw new IllegalArgumentException("잘못된 구분자 포맷입니다. 형식은 //[구분자]\\n 입니다.");
            }

            // 커스텀 구분자 추출
            int newlineIndex = input.indexOf("\n");
            String substring = input.substring(2, newlineIndex);

            // 커스텀 구분자가 한 자리만 입력되었는지 확인
            if (substring.length() > 1) {
                throw new IllegalArgumentException("커스텀 구분자는 한 자리만 입력 가능합니다.");
            }

            return substring;
        }
        // 반환할 커스텀 구분자가 없으면 기본 구분자만 반환
        return ",|:";
    }
}
