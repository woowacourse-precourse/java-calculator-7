package calculator.view;

public class OutputView {

    public void outputMessage(int result) {
        System.out.printf("결과 : %d", result);
    }

    // 오류 발생 시 오류 메시지 출력
    public void outputErrorMessage(String errorMessageInput) {
        System.out.println(errorMessageInput);
    }
}
