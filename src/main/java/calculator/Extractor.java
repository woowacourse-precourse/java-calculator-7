package calculator;

public class Extractor {

    public static String extractNumbers(String inputStr) {
        String numbers = inputStr;

        if (inputStr.startsWith("//")) {
            int newlineIndex = inputStr.indexOf("\\n");

            if (newlineIndex == -1) {
                throw new IllegalArgumentException("잘못된 형식: 커스텀 구분자는 \\n을 포함해야 합니다.");
            }

            numbers = inputStr.substring(newlineIndex + 2);
        }

        return numbers;
    }
}
