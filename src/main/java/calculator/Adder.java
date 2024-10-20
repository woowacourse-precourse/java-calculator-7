package calculator;

public class Adder {
    private final ConvertParseInt parser = new ConvertParseInt();
    private final CheckMinus validator = new CheckMinus();

    // 분리된 문자열을 숫자로 바꿔 더하는 메서드
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
