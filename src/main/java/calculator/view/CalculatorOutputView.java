package calculator.view;

public class CalculatorOutputView {
    private final String additionResultFormat = "%.0f";
    public void printAddGreetingMessage(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }
    public void printAdditionResult(double result){
        System.out.println("결과 : "+String.format(additionResultFormat, result));
    }
}
