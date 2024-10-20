package calculator;

public class Calculator {
    private final InputParser parser;

    public Calculator(InputParser parser) {
        this.parser = parser;
    }

    public int calculateTotalSum() {
        int totalSum = 0;
        String[] numbers = parser.getNumbers();

        for (String num : numbers) {
            try {
                int inputNum = Integer.parseInt(num);
                if (inputNum <= 0) {
                    System.out.println("입력 오류: 양수를 입력해주세요");
                    throw new IllegalArgumentException();
                }
                totalSum += inputNum;
            } catch (NumberFormatException e) {
                System.out.println("입력 오류: 숫자를 입력해주세요");
                throw new IllegalArgumentException();
            }
        }
        return totalSum;
    }
}
