package calculator;

public class Adder {
    private final Parser parser; // Parser 인스턴스 추가

    public Adder() {
        this.parser = new Parser(); // Adder 생성자에서 초기화
    }

    public int calculateSum(String[] numbers) {
        int sum = 0;

        for (String number : numbers) {
            sum += parser.parseNumber(number); // Parser 인스턴스 사용
        }
        return sum;
    }


}
