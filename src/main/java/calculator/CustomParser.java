package calculator;

import java.util.Arrays;

public class CustomParser {
    private final String BASIC_SEPARATOR;

    public CustomParser() {
        this.BASIC_SEPARATOR = ",|:";
    }

    public int[] parse(String input) {
        String regx = "([0-9][,:])+[0-9]";
        if (input.matches(regx)) { // 기본 구분자를 사용할 경우
            return parse(input, this.BASIC_SEPARATOR);
        }
        if (input.matches("//.\\\\n.*")) { // 커스텀 구분자를 사용할 경우
            String separator = input.charAt(2) + "";
            String temp = input.substring(5);
            return parse(temp, this.BASIC_SEPARATOR + "|" + separator);
        }
        throw new IllegalArgumentException("입력 형식을 확인해주세요.");
    }

    private int[] parse(String input, String separator) {
        if (input.isEmpty()) { // 빈 문자열일 경우
            return new int[]{0};
        }
        int[] result;
        try {
            result = Arrays.stream(input.split(separator)).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            throw new IllegalArgumentException("입력 형식을 확인해주세요. (문자 x, 구분자는 숫자 사이에만 존재할 수 있습니다)");
        }
        Arrays.stream(result).forEach(i -> {
            if (i < 0) {
                throw new IllegalArgumentException("음수는 허용하지 않습니다.");
            }
        });
        return result;
    }

}
