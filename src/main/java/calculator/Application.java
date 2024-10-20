package calculator;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        String req = input.input();

        CustomSeparator customSeparator = new CustomSeparator();
        Calculator calculator = new Calculator();

        System.out.println("결과 : " + calculator.calculate(req, customSeparator.customSeparator(req)));
    }
}

