package calculator;

public class StringParser {
    public String[] parse(String input) {
        // 구분자 정의 `,` 혹은 `:`
        String delimiter = "[,:]";

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {

            // \\n라고 적어야 `\`, `n` 검색 가능
            // \\는 escape 문자로, `\\`를 `\` 한 글자로 취급함
            int delimiterIndex = input.indexOf("\\n");

            // 커스텀 구분자 입력이 정상적으로 되었는지 확인
            if (delimiterIndex != -1) {

                // 커스텀 구분자가 2글자 이상일 경우를 가정 -> 정규 표현식 사용
                delimiter = "[" + input.substring(2, delimiterIndex) + "]";

                // 기존 방식: \n = 1글자 => Index + 1
                // 현재 방식: \\n = 2글자 => Index + 2 (escape 문자 고려)
                input = input.substring(delimiterIndex + 2);
            } else {
                throw new IllegalArgumentException("유효하지 않은 커스텀 구분자 형식입니다.");
            }
        }

        // 정의된 구분자로 문자열 처리
        return input.split(delimiter);
    }
}
