package calculator.view;

public class OutputView {

    public void printCalculatorStartMessage() {
        System.out.println("계산기를 시작합니다.");
    }

    public void printCalculatorResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void printCalculatorEndMessage() {
        System.out.println("계산기가 종료되었습니다.");
    }

}
