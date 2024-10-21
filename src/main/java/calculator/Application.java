package calculator;

public class Application {
    public static void main(String[] args) {

        Division division = new Division();
        Input input = new Input();
        Calculator calculator = new Calculator();

        if (input.isCustomDivision()) {
            String customDivision = input.findCustomDivision();
            division.add(customDivision);
        }
        String inputWord = input.numbers();
        calculator.run(inputWord, division);
        System.out.println("결과 : " + calculator.result());

    }
}
