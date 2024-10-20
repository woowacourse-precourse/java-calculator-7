package calculator;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputClass inputClass = new InputClass();
        String inputText = inputClass.input();
        CalculatorStrategy calculatorStrategy;

        if (inputClass.existCustomSeparator(inputText)) {
            calculatorStrategy = new CustomSeparatorStrategy();
            calculatorStrategy.calculate(inputText);
        }


        if (inputClass.existOriginalSeparator(inputText)) {
            calculatorStrategy = new OriginalSeparatorStrategy();
            calculatorStrategy.calculate(inputText);
        }


        //입력값이 아무값도 들어오지 않은 경우
        if (inputClass.isInputBlank(inputText)) {
            System.out.println("결과 : 0");
        }

        //입력값이 숫자 또는 문자 또는 문자열이 들어왔을 때 분기점
        if (inputClass.checkOnlyNumber(inputText)) {
            System.out.println("결과 : " + inputText);
        }
    }
}