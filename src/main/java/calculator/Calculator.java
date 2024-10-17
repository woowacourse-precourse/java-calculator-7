package calculator;

public class Calculator {
    // 기본 구분자로 숫자 분리 및 합 계산 기능 구현
    public int add(String input) {
        String delimiter = ",|:"; // 기본 구분자

        if (input.startsWith("//")) {
            input = input.replace("\\n", "\n");
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        String[] numbers = input.split(delimiter);
        return calculateSum(numbers);
    }

    // 숫자의 합 계산
    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = validateAndParse(number);
            sum += num;
        }
        return sum;
    }

    // 유효성 검사 및 숫자 변환
    private int validateAndParse(String number) {
        try {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 값입니다: " + number);
        }
    }

}
