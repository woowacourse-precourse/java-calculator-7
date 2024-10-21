package calculator;

public class OperationService {
    // TODO customDelimiter 확인 기능 추가
    public static int sumStringNum(String stringNum) {

        String delimiter = ",|:";

        String[] values = stringNum.split(delimiter);
        int sum = 0;

        for (String value : values) {
            int number = parsePositiveInt(value);
            sum += number;
        }

        return sum;
    }

    // 양수만 처리하고, 잘못된 값에 대해 예외 발생
    private static int parsePositiveInt(String value) {
        try {
            int number = Integer.parseInt(value);
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + value);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + value);
        }
    }
}



