package calculator.service;

public class SumCalculator {

    public int sum(String[] inputs) {
        int result = 0;

        for (String input : inputs) {
            try {
                int number = Integer.parseInt(input);
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다. 입력된 값: " + input);
                }
                result += number;
            } catch (NumberFormatException ex) {
                // 숫자가 아닌 문자가 들어온 경우 처리
                throw new IllegalArgumentException("구분자 외의 문자는 입력할 수 없습니다." + input, ex);
            } catch (IllegalArgumentException ex) {
                // 음수가 들어온 경우 처리
                throw new IllegalArgumentException(ex.getMessage(), ex);
            }
        }

        return result;
    }
}
