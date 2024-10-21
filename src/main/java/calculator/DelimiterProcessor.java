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
            return input.substring(2, newlineIndex);
        }
        // 반환할 커스텀 구분자가 없으면 기본 구분자만 반환
        return ",|:";
    }
}
