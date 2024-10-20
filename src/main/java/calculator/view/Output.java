package calculator.view;


public class Output {

    public static void startCalculate() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public static void displayResult(Number result) {
        String output = "결과 : " + result;
        System.out.println(output);
    }
}
