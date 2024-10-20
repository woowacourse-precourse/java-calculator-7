package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // Calculation, IOManager 객체 생성하기
        Calculation calData = new Calculation();
        IOManager ioManager = new IOManager();

        // 입력 문자열 받아서 calData의 분석 함수에 넣어주기
        String input = ioManager.inputCalculationString();
        calData.splitInputString(input);
        int result = calData.returnAddition();
        ioManager.printCalculation(result);
    }
}
