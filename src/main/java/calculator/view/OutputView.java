package calculator.view;

public class OutputView {

    // 계산 결과 출력 메서드
    public void printResult(int result) {
        // 결과 출력 메시지와 함께 결과 값 출력
        System.out.println(ViewMessage.RESULT_MESSAGE.getMessage() + result);
    }

    
}
