package calculator;

public class CustomSeparator {
    public String[] customSeparator(String input) {
        input = input.replace("\\n", "\n");

        // 첫 번째 조건: 입력 문자열에 줄바꿈이 있는지 확인
        if (!input.contains("\n")) {
            return null;
        }

        String[] part = input.split("\n");

        // 두 번째 조건: 첫 번째 부분이 "//"로 시작하는지 확인
        if (part[0].startsWith("//")) {
            String customSeparator = part[0].replaceFirst("//", "");

            // 커스텀 구분자가 한 문자인지 확인
            if (customSeparator.length() == 1) {
                return new String[]{part[1], customSeparator};
            }
            throw new IllegalArgumentException("커스텀 구분자는 한 문자여야 합니다.");
        }
        return null;
    }
}

