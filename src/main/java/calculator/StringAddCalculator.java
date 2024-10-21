package calculator;

public class StringAddCalculator {
    public static int add(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";  // 기본 구분자 선언 및 초기화

        // 커스텀 구분자가 있는 경우 처리
        if (text.startsWith("//")) {
            int delimiterEndIndex = text.indexOf("\n");
            delimiter = text.substring(2, delimiterEndIndex);  // 커스텀 구분자 설정
            text = text.substring(delimiterEndIndex + 1);  // 실제 숫자 부분 추출
        }

        String[] numbers = text.split(delimiter);  // 구분자로 숫자 분리

        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());  // 공백 제거 후 숫자 합산
        }

        return sum;
    }
}
