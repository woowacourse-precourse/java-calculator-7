package calculator;

import java.util.Arrays;

public class CustomParser {
    private final String BASIC_SEPARATOR;

    public CustomParser() {
        this.BASIC_SEPARATOR = "[,:]";
    }

    public int[] parse(String input) {
        if (input.isEmpty()) { // 빈 문자열일 경우 0반환
            return new int[]{0};
        }

        int[] result = null;

        try {
            result = Arrays.stream(input.split(this.BASIC_SEPARATOR)).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 형식을 확인해주세요(숫자와 기본 구분자만 허용)");
        }

        Arrays.stream(result).forEach(i -> {
            if (i < 0) {
                throw new IllegalArgumentException("음수는 허용하지 않습니다.");
            }
        });

        return result;
    }

}
