package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Calculator calculator = new Calculator();
        calculator.getDivision("//-\n1,2:3-9");
        calculator.getNumbers("1,2:3-9");

        System.out.println(calculator.calculateNumber());
    }
}
