package calculator;

public class ArraySumCalculator {
    private final StringSplitter stringsplitter;

    // StringSplitter 의존성 주입
    public ArraySumCalculator(StringSplitter stringsplitter) {
        this.stringsplitter = stringsplitter;
    }

    // 배열의 각 요소를 더하는 메서드
    public int sumArrayElements(String input) {
        // 입력 문자열을 구분자에 따라 분리
        String[] numbers = stringsplitter.splitString(input);

        // 분리된 요소들을 숫자로 변환하고 더함
        int sum = 0;
        for (String number : numbers) {
            if (!number.trim().isEmpty()) {
                sum += Integer.parseInt(number.trim());
            }
        }

        return sum;
    }
}
