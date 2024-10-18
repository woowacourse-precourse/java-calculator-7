package calculator.view;

public class OutPutView {

    public void printCalculatorStartMessage() {
        System.out.println("계산기를 시작합니다.");
    }

    public void printCalculatorResult(int ans) {
        System.out.println("결과 : " + ans);
    }

    public void printCalculatorEndMessage() {
        System.out.println("계산기가 종료되었습니다.");
    }

}
