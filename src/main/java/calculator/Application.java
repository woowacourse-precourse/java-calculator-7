package calculator;

public class Application {
    public static void main(String[] args) {
        String input = Input.inputString();

        StringFilter strF = new StringFilter();
        Calculator cal = new Calculator();

        String[] numbers = strF.checkString(input);

        System.out.println("결과 : " + cal.result(numbers));

    }
}
