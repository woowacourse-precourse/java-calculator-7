package calculator;

public class Division {
    public static String[] StringDivision(String input) {
        String separator = ",|:"; // 기본 구분자
        String nums = input;

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            int customSeparatorIndex = input.indexOf("\\n");
            if (customSeparatorIndex == -1 || customSeparatorIndex == 0) {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
            separator = input.substring(2, customSeparatorIndex); // 커스텀 구분자 지정
            nums = input.substring(customSeparatorIndex + 2); // 커스텀 구분자 이후의 문자열
        }

        if (nums.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }

        return nums.split(separator); // 문자열 분리
    }
}
