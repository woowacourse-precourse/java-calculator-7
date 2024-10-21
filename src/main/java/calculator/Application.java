package calculator;

public class Application {
    public static void main(String[] args) {

        String customDivision = Input.findCustomDivision();

        if (Input.findCustomDivision() != null)
            Division.add(customDivision);

        Calculator.run(Input.numbers(), Division.regularExpression());

        System.out.println("결과 : " + Calculator.result());

    }
}
