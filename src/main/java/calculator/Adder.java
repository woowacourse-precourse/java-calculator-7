package calculator;

public class Adder {
    Number number = new Number();

    public void sumNumbers(String[] numbers) {
        int sum = 0;
        for (String num : numbers) {
            sum += number.validateAndParseNumber(num);
        }
        System.out.println("결과 : " + sum);
    }
}
