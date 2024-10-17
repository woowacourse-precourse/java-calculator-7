package calculator.view;

public class OutputView {
    /**
     * 정수 배열의 요소들은 전부 더한 값을 반환
     */
    public int sumElements(int[] array) {
        int result = 0;
        for (int number : array) {
            result += number;
        }
        return result;
    }

    /**
     * 고정 메세지 및 결과값 출력
     */
    public void printResult(String message, int result) {
        System.out.println(message + result);
    }
}
