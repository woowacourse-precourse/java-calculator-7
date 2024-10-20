package calculator.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorView {

    private BufferedReader reader;

    public CalculatorView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * 사용자로부터 문자열 입력을 받아 반환합니다.
     * @return 입력한 문자열 또는 예외 오류
     */
    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "입력이 잘못되었습니다.";
        }
    }

    public void showResult(int result) {
        // TODO: 계산 결과를 출력
    }
}
