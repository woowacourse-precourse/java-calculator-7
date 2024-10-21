public class SumFromString {
    // 입력이 커스텀 구분자로 시작하는지 확인
    if (input.startsWith("//")) {
        int delimiterEndIndex = input.indexOf("\n");

        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("올바르지 않은 형식입니다. \\n이 없습니다.");
        }

        String customDelimiter = input.substring(2, delimiterEndIndex);
        delimiter = delimiter + "|" + customDelimiter;  // 기본 구분자와 결합
        numbers = input.substring(delimiterEndIndex + 1);  // 숫자 부분 추출
    }
}
