package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        UserInput userInput = new UserInput();
        SumCalculator calculator = new SumCalculator();

        String input = userInput.getInput();
        String delimiter = userInput.getDelimiter();

        try {
            int sum = calculator.calculateSum(input, delimiter);
            System.out.println("결과 : " + sum);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}