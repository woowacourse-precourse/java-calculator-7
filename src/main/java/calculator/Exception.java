package calculator;

public class Exception {
    private DelimiterParser delimiterParser = new DelimiterParser();

    public int[] validate(String input){
        String[] operand=delimiterParser.parse(input);

        if (operand.length == 0) {
            return new int[]{0}; // 공백일 경우 0을 포함한 배열 반환
        }

        int[] numbers = new int[operand.length];
        for (int i = 0; i < operand.length; i++) {
            try {
                int number = Integer.parseInt(operand[i]);

                // 음수 및 0 체크
                if (number <= 0) {
                    throw new IllegalArgumentException("양수가 아닙니다.");
                }
                numbers[i] = number; // 유효한 경우 숫자 배열에 저장
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자가 아닙니다.");
            }
        }

        return numbers; // 변환된 정수형 배열 반환

    }
}
