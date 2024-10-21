package calculator;

public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        Division division = new Division();
        Calculator calculator = new Calculator();

        String customDivision = input.findCustomDivision();

        if (input.findCustomDivision() != null)
            division.add(customDivision);

//        String inputWord = input.numbers();
//        calculator.run(inputWord, division);
        calculator.run(input, division);

        System.out.println("결과 : " + calculator.result());

    }
}
