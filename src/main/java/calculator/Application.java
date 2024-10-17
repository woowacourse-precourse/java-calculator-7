package calculator;

public class Application {
    public static void main(String[] args) {

        InputString input = new InputString();
        String req = input.inputString();

        CustomSeparator customSeparator = new CustomSeparator();
        Calculator calculator = new Calculator();

        System.out.println("결과 : " + calculator.calculation(req, customSeparator.setCustomSeparator(req)));
    }
}
