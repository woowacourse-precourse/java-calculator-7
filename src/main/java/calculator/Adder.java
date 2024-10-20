package calculator;

public class Adder {
    private final ConvertParseInt parser = new ConvertParseInt();
    private final CheckMinus validator = new CheckMinus();

    /**
     * 분리된 문자열 배열을 숫자로 변환하여 합을 계산하는 메서드
     *
     * @param numbers 분리된 문자열 배열
     * @return 문자열 배열의 합
     */
    public int sumNumbers(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int num = parser.convertParseInt(number);
            validator.checkMinus(num);
            sum += num;
        }
        return sum;
    }
}
