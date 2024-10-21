package calculator;

public class Application {
    public static void main(String[] args) {
        String str = camp.nextstep.edu.missionutils.Console.readLine();
        Calculator calculator = new Calculator();
        int result = calculator.calculate(str);
        System.out.println("결과 : " + result);
    }
}
