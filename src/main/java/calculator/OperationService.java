package calculator;


public class OperationService {

    public static int sumStringNum(String stringNum, String delimiter) {
        int sum = 0;

        if (stringNum == null || stringNum.isEmpty()) {
            throw new IllegalArgumentException("stringNum은 null 또는 empty.");
        }

        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException("delimiter은 null 또는 empty.");
        }
        String[] values = stringNum.split(delimiter);

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



